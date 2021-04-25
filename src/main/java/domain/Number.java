package domain;

import exception.BaseBallGameFailureException;
import exception.ErrorCode;
import utils.StringUtils;

import java.util.Objects;

public class Number {
    private final int number;
    private final int position;

    private static final int MAXIMUM_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 1;

    private Number(int number, int position) {
        validationCheck(number);
        this.number = number;
        this.position = position;
    }

    public static Number of(int number, int position) {
        return new Number(number, position);
    }

    public static Number of(String number, int position) {
        return new Number(StringUtils.parseInt(number), position);
    }

    public int getNumber() {
        return number;
    }

    private void validationCheck(int number) {
        if (number > MAXIMUM_NUMBER || number < MINIMUM_NUMBER) {
            throw new BaseBallGameFailureException(ErrorCode.NUMBER_BOUNDARY_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Number) {
            Number other = (Number) o;
            return this.number == other.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
