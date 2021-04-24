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
    @DisplayName("같은 자리에 같은 수가 있는 개수만큼 STRIKE를 가진다.")
    void strike(String answer, String input, Judgements judgement, int expectedCount) {
        BaseBall baseball = new BaseBall(answer);
        Map<Judgements, Integer> hint = baseball.play(input);

        assertThat(hint.get(judgement)).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
            "123, 419, BALL, 1",
            "123, 219, BALL, 2",
            "123, 312, BALL, 3",
    })
    @DisplayName("다른 자리에 같은 숫자를 가진 개수만큼 BALL을 가진다.")
    void ball(String answer, String input, Judgements judgement, int expectedCount) {
        BaseBall baseball = new BaseBall(answer);
        Map<Judgements, Integer> hint = baseball.play(input);

        assertThat(hint.get(judgement)).isEqualTo(expectedCount);
    }
}
