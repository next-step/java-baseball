package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  private static final int RANDOM_NUMBER_SIZE = 3;

  public static List<Integer> generateAnswer() {
    List<Integer> answer = new ArrayList<>();
    while (answer.size() < RANDOM_NUMBER_SIZE) {
      generateRandomNumber(answer);
    }
    return answer;
  }

  public static void generateRandomNumber(List<Integer> list) {
    int random = (int) (Math.random() * 9) + 1;
    if (!list.contains(random)) {
      list.add(random);
    }
  }
}