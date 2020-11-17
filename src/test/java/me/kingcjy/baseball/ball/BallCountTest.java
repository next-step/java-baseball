package me.kingcjy.baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @ParameterizedTest
    @CsvSource(value = {"0:0:낫싱", "1:0:1 스트라이크", "0:1:1 볼", "1:1:1 스트라이크 1 볼"}, delimiter = ':')
    @DisplayName("입력 값에 따른 결과 메세지")
    public void getMessageTest(int strike, int ball, String message) {
        List<Score> scores = new ArrayList<>();

        for (int i = 0; i < strike; i++) {
            scores.add(Score.STRIKE);
        }

        for (int i = 0; i < ball; i++) {
            scores.add(Score.BALL);
        }

        assertThat(new BallCount(scores).getMessage()).isEqualTo(message);
    }
}
