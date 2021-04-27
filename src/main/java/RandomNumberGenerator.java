import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    private static final List<Integer> rangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 9;

    private RandomNumberGenerator() { }

    public static String generate(int size) {
        size = validateSize(size);
        Collections.shuffle(rangeNumbers);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(rangeNumbers.get(i));
        }

        return sb.toString();
    }

    private static int validateSize(int size) {
        if (size < MIN_SIZE) {
            return MIN_SIZE;
        }

        return Math.min(size, MAX_SIZE);

    }
}
