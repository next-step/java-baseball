package baseball.domain;

import baseball.rule.NumbersRule;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Computer {
  private final List<Integer> values;

  private Computer(List<Integer> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Computer generate(NumbersRule numbersRule) {
    return new Computer(numbersRule.get());
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
