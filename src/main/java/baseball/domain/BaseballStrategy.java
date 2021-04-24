package baseball.domain;

import java.util.List;

public interface BaseballStrategy {
  List<BaseballNumber> createNumbers(int size);

}
