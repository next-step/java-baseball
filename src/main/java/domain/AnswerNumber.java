package domain;

import java.util.*;

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
        } while (!isValidatedNumber(randomNumber));
        return new AnswerNumber(randomNumber);
    }

    private static boolean isValidatedNumber(int randomNumber) {
        boolean duplicateNumberExist = isDuplicateNumberExist(randomNumber);
        return !duplicateNumberExist;
    }

    private static int generateRandomNumber() {
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
