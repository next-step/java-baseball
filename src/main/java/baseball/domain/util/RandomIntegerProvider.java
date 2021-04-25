package baseball.domain.util;

import java.util.Random;

public class RandomIntegerProvider {

    private static Random rand = new Random();

    public static int provideRandomNumber(int minNumber, int maxNumber) {
        int randomNumber = rand.nextInt(maxNumber + 1);
        if (randomNumber < minNumber) {
            randomNumber = minNumber;
        }
        return randomNumber;
    }
}