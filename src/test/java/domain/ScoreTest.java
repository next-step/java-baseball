package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("점수")
public class ScoreTest {
    private Balls randomBalls;

    @BeforeEach
    public void setUp() {
        randomBalls = new Balls("123");
    }

    @ParameterizedTest
    @CsvSource(value = {"145|1|0", "124|2|0", "123|3|0", "142|1|1", "918|0|1", "512|0|2", "312|0|3" }, delimiter = '|')
    @DisplayName("점수 확인")
    public void score(String inputText, int strike, int ball) throws Exception {
        Balls inputBalls = new Balls(inputText);

        Score resultScore = randomBalls.matchToScore(inputBalls);
        Score oneStrikeScore = new Score(strike, ball);

        assertThat(resultScore).isEqualTo(oneStrikeScore);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,4", "1,3", "4,0"})
    @DisplayName("스트라이크 + 볼은 3이 최대, 초과 시 에러")
    public void maxCountException(int strike, int ball) throws Exception {
        assertThatThrownBy(() -> new Score(strike, ball))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
