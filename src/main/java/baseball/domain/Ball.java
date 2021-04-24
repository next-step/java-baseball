package baseball.domain;

public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        if (number < 0 || number > 9) {
            throw new NoAllowNumber("숫자는 0~9 사이어야 합니다.");
        }
        return new Ball(number);
    }
}
