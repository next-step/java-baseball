package baseball.domain;

public class Ball {
    private static final Ball[] BALLS = new Ball[10];

    static {
        for(int i = 1; i<BALLS.length; i++) {
            BALLS[i] = new Ball(i);
        }
    }

    private int number;

    private Ball(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Ball of(int number) {
        if(number < 1 || number >= 10) {
            throw new IllegalArgumentException("공의 숫자는 1 이상 9 이하 입니다.");
        }

        return BALLS[number];
    }
}
