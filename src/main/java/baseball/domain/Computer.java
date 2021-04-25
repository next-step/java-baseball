package baseball.domain;

import baseball.rule.NumbersRule;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Computer {
  private static final int DIGIT = 3;
  private static final String ERROR_DIGIT_FORMAT = "%d 자릿수가 아닙니다.";

  private final List<Integer> values;

  private Computer(List<Integer> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Computer generate(NumbersRule numbersRule) {
    List<Integer> values = numbersRule.get();
    checkDigit(values);
    return new Computer(values);
  }

  private static void checkDigit(List<Integer> values) {
    if (values == null || values.size() != DIGIT) {
      throw new IllegalArgumentException(String.format(ERROR_DIGIT_FORMAT, DIGIT));
    }
  }

  public List<Integer> getValues() {
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
