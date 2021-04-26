package util;

import java.util.Random;

public class RandomGenerator {
    private static final int NUMBER_LENGTH = 9;
    private static final int MIN_NUMBER = 1;
    private static final Random random = new Random();

    private RandomGenerator() {}

    public static int value() {
        return MIN_NUMBER + random.nextInt(NUMBER_LENGTH);
    }
}
