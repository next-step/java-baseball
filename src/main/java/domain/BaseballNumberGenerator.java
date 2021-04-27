package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballNumberGenerator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int BASEBALL_SIZE = 3;

    public static List<Integer> generateBaseballNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();

        while(baseballNumbers.size() < BASEBALL_SIZE) {
            addBaseballNumber(baseballNumbers);
        }

        new Validation(baseballNumbers);
        return baseballNumbers;
    }

    private static void addBaseballNumber(List<Integer> baseballNumbers) {
        int randomNumber = generateRandomNumber();
        if (baseballNumbers.contains(randomNumber)) {
            return;
        }
        baseballNumbers.add(randomNumber);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }
}
