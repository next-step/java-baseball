package generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballAnswerNumberGenerator {

  public List<Integer> generate(int size) {
    Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < size) {
      int number = (int) (Math.random() * 9) + 1;
      numbers.add(number);
    }
    return new ArrayList<>(numbers);
  }

}
