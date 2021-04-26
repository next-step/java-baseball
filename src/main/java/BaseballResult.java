public class BaseballResult {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTTING = "낫싱";

    private int strike;
    private int ball;

    public BaseballResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return NOTTING;
        }
        if ((strike > 0 && ball == 0) || strike == 3) {
            return strike + " "+ STRIKE;
        }
        if (strike == 0 && ball > 0) {
            return ball + " "+ BALL;
        }
        return strike + " "+ STRIKE + " " + ball + " "+ BALL;
    }
}