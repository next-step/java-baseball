package domain;

public class NumberBall {
    private static final String RANGE_ERROR = "숫자범위는 1 ~ 9 입니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int numberBall;

    public NumberBall(int number) {
        validRange(number);
        this.numberBall = number;
    }

    private void validRange(int number) {
        if (number < MIN_NUMBER
                || MAX_NUMBER < number) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public int toInt() {
        return numberBall;
    }
}
