package me.kingcjy.baseball.ball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
class BallCountTest {

    @Test
    public void createTest() {
        BallCount ballCount = new BallCount(Arrays.asList(Score.STRIKE, Score.BALL, Score.NOTHING));
    }

    @Test
    public void countTest() {
        BallCount ballCount = new BallCount(Arrays.asList(Score.STRIKE, Score.BALL, Score.NOTHING));

        assertThat(ballCount.countStrike()).isEqualTo(1);
        assertThat(ballCount.countBall()).isEqualTo(1);
        assertThat(ballCount.isFinish()).isFalse();
    }
}