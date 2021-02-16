package model;

public class Number {
    private final int number;

    private Number(final int number) {
        validate(number);
        this.number = number;
    }

    public void validate(final int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    public int getNumber() {
        return number;
    }

    public static Number of (int number) {
        return new Number(number);
    }
}
