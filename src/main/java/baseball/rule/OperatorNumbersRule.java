package baseball.rule;

import baseball.domain.Number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperatorNumbersRule implements NumbersRule {
  private static final List<Number> LESS_THEN_10_NUMBERS;

  static {
    LESS_THEN_10_NUMBERS = Arrays.asList(
            Number.create(1),
            Number.create(2),
            Number.create(3),
            Number.create(4),
            Number.create(5),
            Number.create(6),
            Number.create(7),
            Number.create(8),
            Number.create(9));
  }

  @Override
  public List<Number> get() {
    Collections.shuffle(LESS_THEN_10_NUMBERS);
    return Collections.unmodifiableList(LESS_THEN_10_NUMBERS.subList(0, 3));
  }
}
