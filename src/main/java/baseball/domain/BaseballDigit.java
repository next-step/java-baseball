package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballDigit {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String OUT_OF_RANGE_EXCEPTION = "잘못된 숫자입니다.";

    private final List<Integer> DIGITS = new ArrayList<>();

    public BaseballDigit() {
    }

    public BaseballDigit(String numbers) {
        addBallNumbers(numbers);
    }

    public void addBallNumbers(String numbers) {
        String[] divideNumbers = numbers.split("");
        for (String number : divideNumbers) {
            int ballNumber = convertStringToInt(number);
            validateNumberRange(ballNumber);
            DIGITS.add(ballNumber);
        }
    }

    public void addBallNumbers(int ballNumber) {
        DIGITS.add(ballNumber);
    }

    public List<Integer> getBaseballValues() {
        return DIGITS;
    }

    private int convertStringToInt(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
        }
        return Integer.parseInt(number);
    }

    private void validateNumberRange(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }
}
