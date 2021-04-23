package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
    private final int MAX_SIZE = 3;
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;
    private final Set<Integer> numbers;
    private final Random random;

    public RandomGenerator() {
        this.numbers = new HashSet<>();
        this.random = new Random();
    }

    public Set<Integer> makeNumbersLessThanTen() {
        while (numbers.size() < MAX_SIZE) {
            int num = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            numbers.add(num);
        }

        return numbers;
    }
}
