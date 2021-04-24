package baseball.domain;

public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        return new Ball(number);
    }
}
