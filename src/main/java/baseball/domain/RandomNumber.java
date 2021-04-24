package baseball.domain;

import java.util.Random;

public class RandomNumber implements OneDigitNumber {
    @Override
    public int value() {
        return new Random().nextInt(10);
    }
}
