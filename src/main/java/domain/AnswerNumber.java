package domain;

import java.util.*;

public class AnswerNumber {
    private static final Random random = new Random();

    private final int number;

    private AnswerNumber(int number) {
        this.number = number;
    }

    public static AnswerNumber init() {
        int randomNumber;
        do {
            randomNumber = generateThreeRandomNumber();
        } while (!isValidNumber(randomNumber));
        return new AnswerNumber(randomNumber);
    }

    private static boolean isValidNumber(int randomNumber) {
        if (!isDuplicateNumberExist(randomNumber)) {
            return false;
        }
        return isThreeLengthNumber(randomNumber);
    }

    protected static boolean isThreeLengthNumber(int randomNumber) {
        String numberString = String.valueOf(randomNumber);
        return numberString.length() == 3;
    }

    private static int generateThreeRandomNumber() {
        return random.nextInt(900) + 100;
    }

    protected static boolean isDuplicateNumberExist(int randomNumber) {
        String numberString = String.valueOf(randomNumber);
        String[] split = numberString.split("");
        Set<String> set = new HashSet<>(Arrays.asList(split));
        return set.size() != 3;
    }

    public int getNumber() {
        return number;
    }
}
