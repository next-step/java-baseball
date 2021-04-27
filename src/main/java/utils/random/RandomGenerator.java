package utils.random;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
    private static final Random random = new Random();

    private RandomGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> integerListGeneratorNotDuplicate(int count, int boundMin, int boundMax) {
        Set<Integer> set = new LinkedHashSet<>();

        while (set.size() < count) {
            set.add(random.nextInt(boundMax) + boundMin);
        }

        return new ArrayList<>(set);
    }
}
