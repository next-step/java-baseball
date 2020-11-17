package domain;

import exception.BaseBallException;
import exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class SourceNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_INDEX = 1;

    private static List<BaseBallNumber> sourceBallNumbers = new ArrayList<>();

    private SourceNumbers() {
    }

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            sourceBallNumbers.add(new BaseBallNumber(i));
        }
    }

    public static List<BaseBallNumber> getSourceBallNumbers() {
        return new ArrayList<>(sourceBallNumbers);
    }

    public static BaseBallNumber getBall(int ballNumber) {
        checkNumberRange(ballNumber);
        return sourceBallNumbers.get(ballNumber - NUMBER_INDEX);
    }

    private static void checkNumberRange(int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new BaseBallException(ExceptionMessage.NONE_VALID_INPUT_RANGE);
        }
    }
}
