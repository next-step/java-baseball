package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomStrategy implements BaseballStrategy{

  public static final List<BaseballNumber> BASEBALL_NUMBER_RANGE = new ArrayList<>();

  static {
    for (int i = 0; i < 10; i++) {
      BASEBALL_NUMBER_RANGE.add(i, new BaseballNumber(i));
    }
  }

  @Override
  public List<BaseballNumber> createNumbers(int size) {
    Collections.shuffle(BASEBALL_NUMBER_RANGE);
    List<BaseballNumber> numbers = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      numbers.add(BASEBALL_NUMBER_RANGE.get(i));
    }
    return numbers;
  }
}
