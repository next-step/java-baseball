package me.kingcjy.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
public class BallTest {

    @Test
    @DisplayName("다른 Ball과 비교해 볼카운트를 리턴한다. FinishTest")
    public void judgeBallCountTest() {
        Ball ball = new Ball(new int[]{1, 2, 3});
        Ball other = new Ball(new int[]{1, 2, 3});

        BallCount ballCount = ball.judgeBallCount(other);
        assertThat(ballCount.isFinish()).isTrue();
    }

    @Test
    @DisplayName("다른 Ball과 비교해 볼카운트를 리턴한다. 1s, 1b")
    public void judgeBallCountTest2() {
        Ball ball = new Ball(new int[]{1, 2, 3});
        Ball other = new Ball(new int[]{1, 3, 4});

        BallCount ballCount = ball.judgeBallCount(other);

        assertThat(ballCount.countStrike()).isEqualTo(1);
        assertThat(ballCount.countBall()).isEqualTo(1);
        assertThat(ballCount.isFinish()).isFalse();
    }

}
