package domain;

import java.util.Objects;

public class Number {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;
    private static final String NUMBER_VALID_MESSAGE = "유효하지 않은 범위의 숫자입니다.";

    private final int number;

    private Number(int number) {
        numberValid(number);
        this.number = number;
    }

    private void numberValid(int number) {
        if (isNotRangeClosed(number)) {
            throw new IllegalArgumentException(NUMBER_VALID_MESSAGE);
        }
    }

    private boolean isNotRangeClosed(int number) {
        return number < NUMBER_MIN || number > NUMBER_MAX;
    }

    public static Number valueOf(int number) {
        return new Number(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
