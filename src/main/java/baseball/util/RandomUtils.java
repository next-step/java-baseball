package baseball.util;

import java.util.Random;

public class RandomUtils {

    private static final String NON_CREATE_MESSAGE = "유틸 객체는 생성 불가";

    private RandomUtils() {
        throw new IllegalStateException(NON_CREATE_MESSAGE);
    }

    public static int getRandomNumber(int minNumber, int maxNumber) {
        Random random = new Random();
        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }
}
