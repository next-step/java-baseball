package domain;

import java.util.Random;

public class RandomGenerator implements NumberGenerable {

    private static final int MAX_RANDOM_NUMBER = 1000;
    public static final int MINIMUM_RANDOM_NUMBER = 111;

    private final Random random = new Random();

    @Override
    public String generate() {
        return String.valueOf(random.nextInt(MAX_RANDOM_NUMBER - MINIMUM_RANDOM_NUMBER) + MINIMUM_RANDOM_NUMBER);
    }
}
