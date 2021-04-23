package baseball.domain;

public class Ball {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final Ball[] BALLS = new Ball[MAXIMUM_NUMBER + 1];

    static {
        for(int i = MINIMUM_NUMBER; i<BALLS.length; i++) {
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
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            String exceptionMessage = String.format("공의 숫자는 %d 이상 %d 이하 입니다.", MINIMUM_NUMBER, MAXIMUM_NUMBER);

            throw new IllegalArgumentException(exceptionMessage);
        }

        return BALLS[number];
    }
}
