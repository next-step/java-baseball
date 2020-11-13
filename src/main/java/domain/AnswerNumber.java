package domain;

import java.util.Random;

public class AnswerNumber {
    private static final Random random = new Random();

    private int number;

    private AnswerNumber(int number) {
        this.number = number;
    }

    public static AnswerNumber init() {
        int randomNumber;
        do {
            randomNumber = generateRandomNumber();
        } while (isValidatedNumber(randomNumber));
        return new AnswerNumber(randomNumber);
    }

    private static boolean isValidatedNumber(int randomNumber) {
        boolean duplicateNumberExist = isDuplicateNumberExist(randomNumber);
        return false;
    }

    private static int generateRandomNumber() {
        return random.nextInt(900) + 100;
    }

    private static boolean isDuplicateNumberExist(int randomNumber) {
        return false;
    }

    public int getNumber() {
        return number;
    }
}
