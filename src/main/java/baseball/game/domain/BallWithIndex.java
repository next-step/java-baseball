package baseball.game.domain;

import baseball.game.domain.game.BallResultType;
import java.util.Objects;

public class BallWithIndex {
    private final Integer index;
    private final Ball ball;

    public BallWithIndex(Integer index, Ball ball) {
        this.index = index;
        this.ball = ball;
    }

    public BallResultType getBallResultType(BallWithIndex ballWithIndex) {
        if(ballWithIndex == null) {
            return BallResultType.NOT_THING;
        }

        if(this.equals(ballWithIndex)) {
            return BallResultType.STRIKE;
        }

        if(this.ball.equals(ballWithIndex.ball)) {
            return BallResultType.BALL;
        }

        return BallResultType.NOT_THING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallWithIndex that = (BallWithIndex) o;
        return Objects.equals(index, that.index) &&
            Objects.equals(ball, that.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, ball);
    }
}
