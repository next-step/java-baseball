package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BaseballRandomDigits {
    private static final int TOTAL_DIGIT_COUNT = 3;
    private static final int BASEBALL_DIGIT_RANGE = 9;

    private final Random random = new Random();
    private final List<BaseballDigit> baseballRandomDigits = new ArrayList<>();

    public BaseballRandomDigits() {
    }

    public BaseballDigit generateBaseballRandomDigits() {
        BaseballDigit baseballRandomDigits = new BaseballDigit();
        for (int i = 1; i <= TOTAL_DIGIT_COUNT; i++) {
            int baseballNumber = random.nextInt(BASEBALL_DIGIT_RANGE) + 1;
            baseballRandomDigits.addBallNumbers(baseballNumber);
        }
        return baseballRandomDigits;
    }
}
