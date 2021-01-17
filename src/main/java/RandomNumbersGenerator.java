import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {

    private static final Random random = new Random();
    private static final int NUMBERS_REQUIRED_SIZE = 3;

    public static Numbers generate() {
        return new Numbers(getRandomNumbers());
    }

    private static List<Integer> getRandomNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBERS_REQUIRED_SIZE) {
            int number = random.nextInt(9) + 1;
            numbers.add(number);
        }
        return List.copyOf(numbers);
    }
}
