package domain;

import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        numberValid(number);
        this.number = number;
    }

    private void numberValid(int number) {
        if (isNotRangeClosed(number)) {
            throw new IllegalArgumentException("유효하지 않은 범위의 숫자입니다.");
        }
    }

    private boolean isNotRangeClosed(int number) {
        return number < 1 || number > 9;
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
        return "domain.Number{" +
                "number=" + number +
                '}';
    }
}
