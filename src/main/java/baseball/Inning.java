package baseball;

public class Inning {
    private int strike;
    private int ball;

    public Inning(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
