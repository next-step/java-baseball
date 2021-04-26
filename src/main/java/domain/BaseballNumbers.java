package domain;

import static domain.BaseballNumber.MAXIMUM_BALL_NUMBER;
import static domain.BaseballNumber.MINIMUM_BALL_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {

  private static final int BASEBALL_NUMBERS_SIZE = 3;
  private static final List<BaseballNumber> BASEBALL_NUMBERS_POOL = new ArrayList<>();

  static {
    for (int i = MINIMUM_BALL_NUMBER; i <= MAXIMUM_BALL_NUMBER; i++) {
      BASEBALL_NUMBERS_POOL.add(BaseballNumber.from(i));
    }
  }

  private List<BaseballNumber> baseballNumbers;

  private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
    validate(baseballNumbers);
    this.baseballNumbers = baseballNumbers;
  }

  public boolean isExpectedPosition(BaseballNumber baseballNumber, int index) {
    return baseballNumbers.indexOf(baseballNumber) == index;
  }

  public boolean isContains(BaseballNumber baseballNumber) {
    return baseballNumbers.contains(baseballNumber);
  }

  public int size() {
    return baseballNumbers.size();
  }

  private void validate(List<BaseballNumber> baseballNumbers) {
    if(baseballNumbers.size() != BASEBALL_NUMBERS_SIZE) {
      throw new IllegalArgumentException("야구공은 3자리수로 이루어져야만 합니다.");
    }

    if(new HashSet<>(baseballNumbers).size() != baseballNumbers.size()) {
      throw new IllegalArgumentException("야구공은 서로 다른수로 이루어져야만 합니다.");
    }
  }

  public List<BaseballNumber> getBaseballNumbers() {
    return baseballNumbers;
  }

  public static BaseballNumbers from(List<Integer> tokens) {
    List<BaseballNumber> baseballNumbers = new ArrayList<>();

    for (Integer token : tokens) {
      baseballNumbers.add(BaseballNumber.from(token));
    }

    return new BaseballNumbers(baseballNumbers);
  }

  public static BaseballNumbers create() {
    Collections.shuffle(BASEBALL_NUMBERS_POOL);

    List<BaseballNumber> baseballNumbers = new ArrayList<>();

    for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
      baseballNumbers.add(BASEBALL_NUMBERS_POOL.get(i));
    }

    return new BaseballNumbers(baseballNumbers);
  }
}
