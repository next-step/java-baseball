package baseballgame;

import java.util.List;
import java.util.ArrayList;

@FunctionalInterface
public interface AnswerGenerator {
  public int[] generate();
}

class DefaultGenerator implements AnswerGenerator {
  @Override
  public int[] generate() {
    List<Integer> numberPool = createNumberPool();
    return pickRandomNumbers(numberPool);
  }

  private List<Integer> createNumberPool() {
    List<Integer> pool = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      pool.add(i);
    }
    return pool;
  }

  private int[] pickRandomNumbers(List<Integer> list) {
    int[] randomArray = new int[BaseballGame.DIGITS];
    for (int i = 0; i < BaseballGame.DIGITS; i++) {
      randomArray[i] = list.remove(getRandomIndex(list));
    }
    return randomArray;
  }

  private int getRandomIndex(List<Integer> list) {
    return ((int) (Math.random() * list.size()));
  }
}