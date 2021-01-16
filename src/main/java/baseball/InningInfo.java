package baseball;

import java.util.Objects;

public class InningInfo {
    private int strike;
    private int ball;

    public InningInfo(int strike, int ball) {
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
