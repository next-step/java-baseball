package baseball.domain;

import baseball.rule.NumbersRule;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Computer {
  private static final int DIGIT = 3;
  private static final String ERROR_DIGIT_FORMAT = "%d 자릿수가 아닙니다.";

  private final List<Number> values;

  private Computer(List<Number> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Computer generate(NumbersRule numbersRule) {
    List<Number> values = numbersRule.get();
    checkDigit(values);
    return new Computer(values);
  }

  private static void checkDigit(List<Number> values) {
    if (values == null || values.size() != DIGIT) {
      throw new IllegalArgumentException(String.format(ERROR_DIGIT_FORMAT, DIGIT));
    }
  }

  public Map<StrikeZone, Integer> resultOf(List<Number> playerNumbers) {
    Map<StrikeZone, Integer> strikeZoneMap = new HashMap<>();

    for (int i = 0; i < values.size(); i++) {
      Number value = values.get(i);
      boolean isExistNumber = playerNumbers.contains(value);
      boolean isSameDigit = value.equals(playerNumbers.get(i));

      plusCount(strikeZoneMap, StrikeZone.valueOf(isExistNumber, isSameDigit));
    }

    return Collections.unmodifiableMap(strikeZoneMap);
  }

  private void plusCount(Map<StrikeZone, Integer> map, StrikeZone strikeZone) {
    Integer count = map.getOrDefault(strikeZone, 0);
    map.put(strikeZone, ++count);
  }

  public List<Number> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Computer computer = (Computer) o;
    return Objects.equals(values, computer.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Computer{" +
            "values=" + values +
            '}';
  }
}
