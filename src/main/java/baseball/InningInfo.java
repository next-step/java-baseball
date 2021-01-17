package baseball;

public class InningInfo {
    private final int strike;
    private final int ball;
    private final int out;

    public InningInfo(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
