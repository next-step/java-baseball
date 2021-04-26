package baseball.domain;

import baseball.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player {
  private final List<Number> values;

  private Player(List<Number> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Player generateNumberString(String numberString) {
    List<Number> result = new ArrayList<>();
    for (Integer number : StringUtil.toIntegerList(numberString)) {
      result.add(Number.create(number));
    }
    return new Player(result);
  }

  public boolean existNumber(Number number) {
    return values.contains(number);
  }

  public int getDigit(Number number) {
    return values.indexOf(number);
  }

  public List<Number> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(values, player.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Player{" +
            "values=" + values +
            '}';
  }
}
