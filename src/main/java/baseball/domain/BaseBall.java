package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall {

  public static final String SIZE_ERROR_MESSAGE = "baseballNumber size must be 3.";
  public static final String EQUALS_VALUE_ERROR_MESSAGE = "numbers can not equals.";
  private static final int SIZE = 3;

  private List<BaseballNumber> baseballNumbers;

  public BaseBall(List<BaseballNumber> baseballNumbers) {
    checkSize(baseballNumbers);
    checkEqualsValue(baseballNumbers);
    this.baseballNumbers = baseballNumbers;
  }

  private void checkEqualsValue(List<BaseballNumber> baseballNumbers) {
    Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);
    if (baseballNumberSet.size() != SIZE) {
      throw new IllegalArgumentException(EQUALS_VALUE_ERROR_MESSAGE);
    }
  }

  private void checkSize(List<BaseballNumber> baseballNumbers) {
    if (baseballNumbers.size() != 3) {
      throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
    }
  }

  public static BaseBall createBaseball(BaseballStrategy strategy) {
    return new BaseBall(strategy.createNumbers(SIZE));
  }

  public static BaseBall createPlayBall(List<Integer> numbers) {
    List<BaseballNumber> baseballNumbers = new ArrayList<>();
    for (Integer number : numbers) {
      baseballNumbers.add(new BaseballNumber(number));
    }
    return new BaseBall(baseballNumbers);
  }

  @Override
  public String toString() {
    return "BaseBall{" +
        "baseballNumbers=" + baseballNumbers +
        '}';
  }
}
