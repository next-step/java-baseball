package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("점수")
public class ScoreTest {
    private NumberBalls randomBalls;

    @BeforeEach
    public void setUp() {
        List<NumberBall> balls = new ArrayList<>();
        balls.add(new NumberBall(1));
        balls.add(new NumberBall(2));
        balls.add(new NumberBall(3));

        randomBalls = new NumberBalls(balls);
    }

    public NumberBalls createInputBalls(String inputText) {
        List<NumberBall> result = new ArrayList<>();
        String[] split = inputText.split(",");
        for (int i = 0; i < split.length; i++) {
            result.add(new NumberBall(Integer.parseInt(split[i])));
        }
        return new NumberBalls(result);
    }

    @Test
    @DisplayName("원 스트라이크 확인")
    public void oneStrike() throws Exception {
        NumberBalls inputBalls = createInputBalls("1,4,5");

        Score resultScore = randomBalls.matchToScore(inputBalls);
        Score oneStrikeScore = new Score(1, 0);

        assertThat(resultScore).isEqualTo(oneStrikeScore);
    }

    @Test
    @DisplayName("투 스트라이크 확인")
    public void twoStrike() throws Exception {
        NumberBalls inputBalls = createInputBalls("1,2,4");

        Score resultScore = randomBalls.matchToScore(inputBalls);
        Score twoStrikeScore = new Score(2, 0);

        assertThat(resultScore).isEqualTo(twoStrikeScore);
    }

    @Test
    @DisplayName("쓰리 스트라이크 확인")
    public void threeStrike() throws Exception {
        NumberBalls inputBalls = createInputBalls("1,2,3");

        Score resultScore = randomBalls.matchToScore(inputBalls);
        Score threeStrikeScore = new Score(3, 0);

        assertThat(resultScore).isEqualTo(threeStrikeScore);
    }

    @Test
    @DisplayName("원 볼 확인")
    public void oneBall() throws Exception {
        NumberBalls inputBalls = createInputBalls("9,8,1");
        Score resultScore = randomBalls.matchToScore(inputBalls);
        Score oneBallScore = new Score(0, 1);

        assertThat(resultScore).isEqualTo(oneBallScore);
    }

}
