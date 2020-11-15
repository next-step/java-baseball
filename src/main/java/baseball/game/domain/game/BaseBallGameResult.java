package baseball.game.domain.game;

import baseball.game.domain.BallWithIndex;
import baseball.game.domain.Balls;

public class BaseBallGameResult {

    private int strikeCount = 0;
    private int ballCount = 0;

    public void result(Balls gameBalls, Balls inputBalls) {
        for(int i = 0; i < gameBalls.getBallsSize(); i++) {
            BallWithIndex ball = gameBalls.getBall(i);
            BallResultType ballResultType = getBallResultType(ball, inputBalls);
            count(ballResultType);
        }
    }

    private BallResultType getBallResultType(BallWithIndex ball, Balls inputBalls) {
        BallResultType result = BallResultType.NOTHING;
        for(int i = 0; i < inputBalls.getBallsSize(); i++) {
            BallWithIndex inputBall = inputBalls.getBall(i);
            result = ball.getBallResultType(inputBall);
            if(result == BallResultType.STRIKE || result == BallResultType.BALL) break;
        }

        return result;
    }

    public void count(BallResultType resultType) {
        if(resultType == BallResultType.STRIKE) {
            this.addStrikeCount();
            return;
        }

        if(resultType == BallResultType.BALL) {
            this.addBallCount();
        }
    }


    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private void addStrikeCount() {
        this.strikeCount++;
    }

    private void addBallCount() {
        this.ballCount++;
    }
}
