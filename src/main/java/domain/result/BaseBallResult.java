package domain.result;

import domain.hint.Ball;
import domain.hint.Strike;
import domain.number.BaseBallNumbers;
import domain.number.ComputerBallNumber;
import domain.number.PlayerBallNumber;

public class BaseBallResult {

    private Strike strike;
    private Ball ball;

    public BaseBallResult(ComputerBallNumber computerBallNumber, PlayerBallNumber playerBallNumber) {
        this.strike = new Strike(BaseBallNumbers.findStrikeCount(computerBallNumber.getBallNumbers(), playerBallNumber.getBallNumbers()));
        this.ball = new Ball(BaseBallNumbers.findBallCount(computerBallNumber.getBallNumbers(), playerBallNumber.getBallNumbers()));
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
