package baseball.domain;

import java.util.Random;

public class RandomNumber implements OneDigitNumber {
    public static final int BOUND = 10;

    @Override
    public int value() {
        return new Random().nextInt(BOUND);
    }
}
