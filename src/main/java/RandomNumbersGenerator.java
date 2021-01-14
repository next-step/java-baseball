import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {

    private static final Random random = new Random();

    public static Numbers generate() {
        return new Numbers(getNumbers());
    }

    private static Set<Integer> getNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3) {
            int number = random.nextInt(9) + 1;
            numbers.add(number);
        }
        return numbers;
    }
}
