package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();

    @Override
    public int nextInt() {
        return random.nextInt(8) + 1;
    }
}
