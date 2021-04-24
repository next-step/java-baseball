package baseball.domain;

public class Ball {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NoAllowNumber("숫자는 0~9 사이어야 합니다.");
        }
        return new Ball(number);
    }

    public static void ofRandom() {
    }
}
