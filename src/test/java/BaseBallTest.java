import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseBallTest {

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱이다.")
    void fourBall() {
        BaseBall baseball = new BaseBall("123");
        Map<Judgements, Integer> play = baseball.play("659");

        assertThat(play).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({
                "123, 189, STRIKE, 1",
                "123, 129, STRIKE, 2",
                "123, 123, STRIKE, 3",
    })
    @DisplayName("같은 수가 같은 자리에 1개 있으면 1스트라이크이다.")
    void oneStrike(String answer, String input, Judgements judgement, int expectedCount) {
        BaseBall baseball = new BaseBall(answer);
        Map<Judgements, Integer> hint = baseball.play(input);

        assertThat(hint.get(judgement)).isEqualTo(expectedCount);
    }
}
