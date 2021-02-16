package model;

public class BallNumber {
    private final int number;

    private BallNumber(final int number) {
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

    public static BallNumber of (int number) {
        return new BallNumber(number);
    }
}
