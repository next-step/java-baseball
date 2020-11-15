package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.domain.game.BallResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallWithIndexTest {

    @Test
    @DisplayName("숫자와 자리가 같을 경우 STRIKE")
    void equals_strike() {
        BallWithIndex ball1 = new BallWithIndex(0, Ball.of(1));
        BallWithIndex ball2 = new BallWithIndex(0, Ball.of(1));

        BallResultType ballResultType = ball1.getBallResultType(ball2);

        assertThat(ballResultType).isEqualTo(BallResultType.STRIKE);
    }


    @Test
    @DisplayName("숫자는 같고 자리는 다른 경우 BALL")
    void equals_ball() {
        BallWithIndex ball1 = new BallWithIndex(0, Ball.of(1));
        BallWithIndex ball2 = new BallWithIndex(1, Ball.of(1));

        BallResultType ballResultType = ball1.getBallResultType(ball2);

        assertThat(ballResultType).isEqualTo(BallResultType.BALL);
    }

    @Test
    @DisplayName("숫자와 자리가 모두 다른 경우 NOT_THING")
    void equals_notThing() {
        BallWithIndex ball1 = new BallWithIndex(0, Ball.of(1));
        BallWithIndex ball2 = new BallWithIndex(1, Ball.of(2));

        BallResultType ballResultType = ball1.getBallResultType(ball2);

        assertThat(ballResultType).isEqualTo(BallResultType.NOTHING);
    }

    @Test
    @DisplayName("비교할 공이 없을 경우 NOT_THING")
    void equals_nullBallNotThing() {
        BallWithIndex ball1 = new BallWithIndex(0, Ball.of(1));

        BallResultType ballResultType = ball1.getBallResultType(null);

        assertThat(ballResultType).isEqualTo(BallResultType.NOTHING);
    }


}