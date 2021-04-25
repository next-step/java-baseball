package precourse.baseball.pitcher;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Pitcher {

  private final Random random;

  public Pitcher(Random random) {
    this.random = random;
  }

  public Set<Integer> pitch() {
    Set<Integer> numbers = new TreeSet<>();

    do {
      for (int i = 0; i < 3; i++) {
        numbers.add(random.nextInt(9) + 1);
      }
    } while (numbers.size() != 3);

    return numbers;
  }
}
