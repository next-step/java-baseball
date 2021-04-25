package domain;

import utils.StringUtils;

import java.util.Objects;

public class Number {
    private final int number;
    private final int position;

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
        if (number > 9 || number < 1) {
            throw new IllegalArgumentException("숫자는 1 ~ 9 사이의 수여야 합니다.");
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
