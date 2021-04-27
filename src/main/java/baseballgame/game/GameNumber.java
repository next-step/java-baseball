package baseballgame.game;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GameNumber {
    private static final int DIGITS = 3;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 9;

    private final List<Integer> numberList;

    private GameNumber(List<Integer> numberList) {
        checkValidation(numberList);
        this.numberList = Collections.unmodifiableList(numberList);
    }

    private void checkValidation(List<Integer> numberList) {
        checkRedundantValidation(numberList);
        checkSizeValidation(numberList);
        for (int number : numberList) {
            checkBoundaryValidation(number);
        }
    }

    private void checkRedundantValidation(List<Integer> numberList) {
        final HashSet<Integer> numberSet = new HashSet<>(numberList);
        if (numberList.size() != numberSet.size()) {
            throw new IllegalArgumentException(String.format("numberList has redundant number. %s", numberList));
        }
    }

    private void checkSizeValidation(List<Integer> numberList) {
        if (numberList.size() != DIGITS) {
            throw new IllegalArgumentException(String.format("size of numberList should be %d.", DIGITS));
        }
    }

    private void checkBoundaryValidation(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(String.format("%d is out of boundary.", number));
        }
    }

    public static GameNumber generateRandomly() {
        final List<Integer> numberList = RandomNumberGenerator.generateRandomNumberList(LOWER_BOUND, UPPER_BOUND, DIGITS);
        return new GameNumber(numberList);
    }

    public static GameNumber of(List<Integer> numberList) {
        return new GameNumber(numberList);
    }

    @Override
    public String toString() {
        return "GameNumber{numberList=" + numberList + '}';
    }
}
