package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  public static List<Integer> generateAnswer() {
    List<Integer> answer = new ArrayList<>();
    while(answer.size() < InputType.MAX_ANSWER_SIZE) {
      generateRandomNumber(answer);
    }
    return answer;
  }

  public static void generateRandomNumber(List<Integer> list) {
    int random = (int) (Math.random() * 9) + 1;
    if(!list.contains(random)) {
      list.add(random);
    }
  }
}