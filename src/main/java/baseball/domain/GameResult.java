package baseball.domain;

public class GameResult {
    private final int strike;
    private final int ball;

    private GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult of(BaseBallNumbers player1, BaseBallNumbers player2) {
        int strike = player1.countSameNumberAndPlaceWith(player2);
        int ball = player1.countSameNumberWith(player2) - strike;

        return new GameResult(strike, ball);
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
