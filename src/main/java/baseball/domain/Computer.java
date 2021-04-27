package baseball.domain;

import baseball.rule.NumbersRule;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Computer extends BaseBallNumbers {
  private final List<Number> values;

  private Computer(List<Number> values) {
    super(values);
    this.values = Collections.unmodifiableList(values);
  }

  public static Computer generate(NumbersRule numbersRule) {
    List<Number> values = numbersRule.get();
    return new Computer(values);
  }

  public BallRecord resultOf(Player player) {
    BallRecord ballRecord = BallRecord.create();

    for (int i = 0; i < values.size(); i++) {
      Number value = values.get(i);
      boolean isExistNumber = player.existNumber(value);
      boolean isSameDigit = i == player.getDigit(value);

      ballRecord = ballRecord.plusCount(StrikeZone.valueOf(isExistNumber, isSameDigit));
    }

    return ballRecord;
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
