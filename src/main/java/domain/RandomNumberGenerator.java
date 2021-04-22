package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int BOUND = 8;
    private static final int ADDITIONAL_NUMBER = 1;

    private static final Random RANDOM = new Random();

    @Override
    public int nextInt() {
        return RANDOM.nextInt(BOUND) + ADDITIONAL_NUMBER;
    }
}
