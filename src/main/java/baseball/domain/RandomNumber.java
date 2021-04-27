package baseball.domain;

import java.util.Random;

public class RandomNumber implements OneDigitNumber {
    private static final int BOUND = 8;

    @Override
    public int value() {
        return new Random().nextInt(BOUND) + 1;
    }
}
