package baseball.domain;

import baseball.exception.BaseballNumberInvalidFormatException;
import baseball.exception.BaseballNumberInvalidRangeException;

public class BaseballNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private int value;

    public BaseballNumber(int value) {
        setValue(value);
    }

    public BaseballNumber(String value) {
        try {
            setValue(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new BaseballNumberInvalidFormatException();
        }

    }

    private void validate(int value) {
        if (value > MAX_NUMBER || value < MIN_NUMBER) {
            throw new BaseballNumberInvalidRangeException();
        }
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        validate(value);
        this.value = value;
    }
}

