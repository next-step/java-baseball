package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import customexceptions.DigitOverMaximumException;

public class RandomGenerator {
    private static final int UPPER_BOUND = 10;

    public String getRandomDigits(int digitCount) {
        if (digitCount >= UPPER_BOUND) {
            throw new DigitOverMaximumException("Digit count must less than 10");
        }

        List<Integer> digits = this.createDigits(digitCount);

        return this.IntsToString(digits);
    }

    private List<Integer> createDigits(int digitCount){
        List<Integer> digits = new ArrayList<>();
        Random rand = new Random();

        int pickCnt = 0;
        while (pickCnt != digitCount) {
            pickCnt += this.tryAdd(digits, rand.nextInt(UPPER_BOUND - 1) + 1);
        }

        return digits;
    }

    private int tryAdd(List<Integer> list, int elem) {
        if (list.contains(elem)) {
            return 0;
        }

        list.add(elem);

        return 1;
    }

    private String IntsToString(List<Integer> ints) {
        StringBuilder strBuilder = new StringBuilder();

        ints.forEach(i -> strBuilder.append(i));

        return strBuilder.toString();
    }
}
