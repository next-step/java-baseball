package baseball;

import java.util.Random;

public class RandomNumber {
    public RandomNumber() {

    }

    public static int createNumber() {
        int hundred = makeRandomNumber();
        int ten = makeRandomNumber();
        int one = makeRandomNumber();

        ten = checkDigits(hundred, one, ten);
        one = checkDigits(hundred, ten, one);

        int randomNumber = hundred * 100 + ten * 10 + one;

        return randomNumber;
    }

    public static int checkDigits(int standardNumber, int compareNumber, int changeNumber) {
        while (standardNumber == changeNumber || compareNumber == changeNumber) {
            changeNumber = makeRandomNumber();
        }

        return changeNumber;
    }

    public static int makeRandomNumber() {
        Random random = new Random();

        return random.nextInt(9)+1;
    }
}
