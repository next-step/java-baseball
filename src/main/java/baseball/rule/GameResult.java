package baseball.rule;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isEndOfGame() {
        return strike >= 3;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0)
            return "낫씽";

        String msg = "";
        if (strike > 0)
            msg += strike + " 스트라이크 ";

        if(ball > 0)
            msg += ball + " 볼 ";

        return msg;
    }
}
