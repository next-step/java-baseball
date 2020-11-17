package domain.number;

import exception.BaseBallException;
import exception.ExceptionMessage;

import java.util.Objects;

public class BaseBallNumber implements Comparable<BaseBallNumber> {

    private static final String BALL_NUMBER_PATTERN = "^[1-9]$";
    private int number;

    public BaseBallNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(final int number) {
        if(!String.valueOf(number).matches(BALL_NUMBER_PATTERN)) {
            throw new BaseBallException(ExceptionMessage.NONE_VALID_INPUT_RANGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(BaseBallNumber otherBaseBallNumber) {
        return this.number - otherBaseBallNumber.number;
    }
}
