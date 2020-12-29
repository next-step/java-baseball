package Model;

public class GuessResult {
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0)
            return "낫싱";
        if (ball == 0)
            return Integer.toString(strike) + " 스트라이크";
        if (strike == 0)
            return Integer.toString(ball) + "볼";
        return Integer.toString(strike) + " 스트라이크 " + Integer.toString(ball) + "볼";
    }
}
