package baseball.domain;

import java.util.List;

public class Score {
    private final Strike strike;
    private final Ball ball;

    public Score() {
        this.strike = Strike.newInstance();
        this.ball = Ball.newInstance();
    }

    public static Score newInstance() {
        return new Score();
    }

    public void countScore(final Answer answer, List<BaseballNumber> baseballNumbers) {
        strike.countStrike(answer, baseballNumbers);
        ball.countBall(answer, baseballNumbers);
    }

    public void initScore() {
        strike.initCount();
        ball.initCount();
    }

    public boolean isAllStrike() {
        return strike.isAllStrike() && ball.isNothing();
    }

    public boolean isNothing() {
        return strike.isNothing() && ball.isNothing();
    }

    public int getStrike() {
        return strike.getCount();
    }

    public int getBall() {
        return ball.getCount();
    }
}
