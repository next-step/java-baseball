package baseball.domain;

import java.util.Map;

public class BaseBallGame {
    private BallMaker ballMaker;
    private Balls balls;

    public BaseBallGame(BallMaker ballMaker) {
        this.ballMaker = ballMaker;
    }

    public void generateBalls() {
        this.balls = ballMaker.generate();
    }

    public Map<Status, Integer> play(Balls balls) {
        return this.balls.match(balls);
    }

    public boolean isDone(Balls balls) {
        return this.balls.equals(balls);
    }
}
