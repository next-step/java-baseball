package baseball.domain;

public class GameResult {
    private final int strike;
    private final int ball;

    private GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult of(BallNumbers first, BallNumbers second) {
        int strike = first.countSameNumberAndDigit(second);
        int ball = first.countDuplicateNumber(second) - strike;

        return new GameResult(strike, ball);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
