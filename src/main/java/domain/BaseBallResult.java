package domain;

public class BaseBallResult {

    private Strike strike;
    private Ball ball;

    public BaseBallResult(ComputerBallNumber computerBallNumber, PlayerBallNumber playerBallNumber) {
        this.strike = new Strike(BaseBallNumbers.findStrikeCount(computerBallNumber.getBallNumbers(), playerBallNumber.getBallNumbers()));
        this.ball = new Ball(BaseBallNumbers.fineBallCount(computerBallNumber.getBallNumbers(), playerBallNumber.getBallNumbers()));
    }

    public Strike getStrike() {
        return strike;
    }

    public Ball getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike.isAllMatching() && ball.isNoMatching();
    }
}
