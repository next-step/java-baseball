package baseball.domain;

import baseball.exception.BaseballNumberInvalidFormatException;
import baseball.exception.BaseballNumberInvalidRangeException;

import java.util.Objects;

public class BaseballNumber {

    private static final int MIN_NUMBER_OF_BASEBALL_NUMBER = 1;
    private static final int MAX_NUMBER_OF_BASEBALL_NUMBER = 9;
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
        if (value > MAX_NUMBER_OF_BASEBALL_NUMBER || value < MIN_NUMBER_OF_BASEBALL_NUMBER) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

