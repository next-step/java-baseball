package nextstep.precourse.domain;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isFourBall() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public boolean isZeroStrike() {
        return strike == 0;
    }

    public boolean isZeroBall() {
        return ball == 0;
    }
}
