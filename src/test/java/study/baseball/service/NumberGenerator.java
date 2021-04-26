package study.baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private static final int GENERATE_LIMIT_COUNT = 3;
    private static final int RANDOM_NUMBER_BOUND  = 10;

    public static List<Integer> generateNumber() {
        List<Integer> generatedNumbers = new ArrayList<>();

        Random random = new Random();
        while(generatedNumbers.size() < GENERATE_LIMIT_COUNT) {
            addNumber(generatedNumbers, random);
        };

        return generatedNumbers;
    }

    private static void addNumber(List<Integer> generatedNumbers, Random rand) {
        int number = rand.nextInt(RANDOM_NUMBER_BOUND);
        if (generatedNumbers.contains(number) == false) {
            generatedNumbers.add(number);
        }
    }
}
