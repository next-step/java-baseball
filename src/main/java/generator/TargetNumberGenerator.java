package generator;

import java.util.HashSet;
import java.util.Set;

public class TargetNumberGenerator {

  public int[] generate(int size) {
    Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < size) {
      int number = (int) (Math.random() * 9) + 1;
      numbers.add(number);
    }
    return setToArray(numbers);
  }

  private int[] setToArray(Set<Integer> numbers) {
    int[] result = new int[numbers.size()];
    int index = 0;
    for (Integer number : numbers) {
      result[index++] = number;
    }
    return result;
  }
}
