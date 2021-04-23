package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements RandomGenerator {
    private final int MAX_SIZE = 3;
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;
    private final List<Integer> numbers;
    private final Random random;

    public RandomNumberGenerator() {
        this.numbers = new ArrayList<>();
        this.random = new Random();
    }

    public List<Integer> makeNumbersLessThanTen() {
        while (numbers.size() < MAX_SIZE) {
            addNonDuplicateNumber();
        }

        return numbers;
    }

    private void addNonDuplicateNumber() {
        int num = randomIntegerNumber();
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }

    private int randomIntegerNumber() {
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
}
