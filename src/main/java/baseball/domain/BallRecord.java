package baseball.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class BallRecord {
  private static final int MAX_COUNT = 3;

  private final Map<StrikeZone, Integer> values;

  private BallRecord(Map<StrikeZone, Integer> values) {
    this.values = Collections.unmodifiableMap(values);
  }

  public static BallRecord create() {
    return new BallRecord(new EnumMap<>(StrikeZone.class));
  }

  public BallRecord plusCount(StrikeZone strikeZone) {
    Map<StrikeZone, Integer> result = new EnumMap<>(StrikeZone.class);
    result.putAll(values);

    int count = getCount(strikeZone);
    result.put(strikeZone, ++count);
    return new BallRecord(result);
  }

  public int getCount(StrikeZone strikeZone) {
    return values.getOrDefault(strikeZone, 0);
  }

  public boolean isStrikeOut() {
    return getCount(StrikeZone.STRIKE) == MAX_COUNT;
  }

  public Map<StrikeZone, Integer> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BallRecord that = (BallRecord) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "BallRecord{" +
            "value=" + values +
            '}';
  }
}
