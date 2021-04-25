import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Questioner {

  public int makeProblem() {
    int random = generate();
    while (hasSame(random)) {
      random = generate();
    }
    return random;
  }

  private int generate() {
    return ThreadLocalRandom.current().nextInt(100, 1000);
  }

  private boolean hasSame(int random) {
    Set<Integer> numbers = new HashSet<>();
    while (random > 0) {
      numbers.add(random % 10);
      random = random / 10;
    }
    return numbers.size() != 3;
  }

}
