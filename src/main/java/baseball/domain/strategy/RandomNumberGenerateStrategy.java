package baseball.domain.strategy;

import java.util.Random;

public class RandomNumberGenerateStrategy implements RandomNumberStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
    }

}
