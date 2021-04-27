package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class BaseBallTest {

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱이다.")
    void fourBall() {
        BaseBall baseball = new BaseBall(new Numbers("123"));
        JudgementCountPair hint = baseball.play(new Numbers("659"));

        assertThat(hint).hasNoNullFieldsOrProperties();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 189, STRIKE, 1",
            "123, 129, STRIKE, 2",
            "123, 123, STRIKE, 3",
            "123, 419, BALL, 1",
            "123, 219, BALL, 2",
            "123, 312, BALL, 3",
    })
    @DisplayName("같은 자리에 같은 수가 있는 개수만큼 해당 판정을 가진다.")
    void strikeOrBall(String answer, String input, Judgements judgement, int expectedCount) {
        BaseBall baseball = new BaseBall(new Numbers(answer));
        JudgementCountPair hint = baseball.play(new Numbers(input));

        assertThat(hint.get(judgement)).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
            "123, 137, 1, 1",
            "123, 132, 2, 1"
    })
    @DisplayName("같은 수가 같은 자리에 1개 있고 다른 자리에 1개 있으면 1스트라이크 1볼이다.")
    void StrikeAndBall(String answer, String input, int expectedBallCount, int expectedStrikeCount) {
        BaseBall baseball = new BaseBall(new Numbers(answer));
        JudgementCountPair hint = baseball.play(new Numbers(input));

        assertAll(
                () -> assertThat(hint.get(Judgements.BALL)).isEqualTo(expectedBallCount),
                () -> assertThat(hint.get(Judgements.STRIKE)).isEqualTo(expectedStrikeCount)
        );
    }
}
