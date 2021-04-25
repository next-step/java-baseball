package baseball.rule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperatorNumbersRule implements NumbersRule {
  private static final List<Integer> LESS_THEN_10_NUMBERS;

  static {
    LESS_THEN_10_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
  }

  @Override
  public List<Integer> get() {
    Collections.shuffle(LESS_THEN_10_NUMBERS);
    return Collections.unmodifiableList(LESS_THEN_10_NUMBERS.subList(0, 3));
  }
}
