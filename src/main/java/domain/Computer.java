package domain;

import java.util.HashSet;
import java.util.Set;

import static domain.BaseballNumber.MAXIMUM_BASEBALL_NUMBER;
import static domain.BaseballNumber.MINIMUM_BASEBALL_NUMBER;

public class Computer extends Player {
    @Override
    protected int pickBaseballNumbers() {
        return generateThreeNumber();
    }

    private int generateThreeNumber() {
        int result = 0;
        Set<Integer> numbers = new HashSet<>();
        for (int digit = 1; digit <= 100; digit *= 10) {
            int uniqueNumber = getUniqueRandomNumber(numbers);
            numbers.add(uniqueNumber);
            result += uniqueNumber * digit;
        }
        return result;
    }

    private int getUniqueRandomNumber(Set<Integer> numbers) {
        int randomNumber;
        do {
            randomNumber = getRandomOneToNineNumber();
        } while (numbers.contains(randomNumber));
        return randomNumber;
    }

    private int getRandomOneToNineNumber() {
        return MINIMUM_BASEBALL_NUMBER
                + (int) (Math.random()
                * ((MAXIMUM_BASEBALL_NUMBER - MINIMUM_BASEBALL_NUMBER) + MINIMUM_BASEBALL_NUMBER));
    }
}
