package domain;

import static domain.BaseballNumber.MAXIMUM_BALL_NUMBER;
import static domain.BaseballNumber.MINIMUM_BALL_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumbers {
  private static final int BASEBALL_NUMBERS_SIZE = 3;
  private static final List<BaseballNumber> BASEBALL_NUMBERS_POOL = new ArrayList<>();

  static {
    for(int i = MINIMUM_BALL_NUMBER; i <= MAXIMUM_BALL_NUMBER; i++) {
      BASEBALL_NUMBERS_POOL.add(BaseballNumber.from(i));
    }
  }

  private List<BaseballNumber> baseballNumbers;

  private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
    this.baseballNumbers = baseballNumbers;
  }

  public List<BaseballNumber> getBaseballNumbers() {
    return baseballNumbers;
  }

  public static BaseballNumbers create() {
    Collections.shuffle(BASEBALL_NUMBERS_POOL);

    List<BaseballNumber> baseballNumbers = new ArrayList<>();

    for(int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
      baseballNumbers.add(BASEBALL_NUMBERS_POOL.get(i));
    }

    return new BaseballNumbers(baseballNumbers);
  }
}
