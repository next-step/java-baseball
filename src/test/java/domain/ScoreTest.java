package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("점수")
public class ScoreTest {
    private Balls randomBalls;

    @BeforeEach
    public void setUp() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1));
        balls.add(new Ball(2));
        balls.add(new Ball(3));

        randomBalls = new Balls(balls);
    }

    public Balls createInputBalls(String inputText) {
        List<Ball> result = new ArrayList<>();
        String[] split = inputText.split(",");
        for (int i = 0; i < split.length; i++) {
            result.add(new Ball(Integer.parseInt(split[i])));
        }
        return new Balls(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,4,5|1|0", "1,2,4|2|0", "1,2,3|3|0", "1,4,2|1|1", "3,1,2|0|3" }, delimiter = '|')
    @DisplayName("점수 확인")
    public void score(String inputText, int strike, int ball) throws Exception {
        Balls inputBalls = createInputBalls(inputText);

        Score resultScore = randomBalls.matchToScore(inputBalls);
        Score oneStrikeScore = new Score(strike, ball);

        assertThat(resultScore).isEqualTo(oneStrikeScore);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,4", "1,3", "4,0"})
    @DisplayName("스트라이크 + 볼은 3이 최대")
    public void maxCountException(int strike, int ball) throws Exception {
        assertThatThrownBy(() -> new Score(strike, ball))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
