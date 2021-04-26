package baseball.opponent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OpponentTest {

    Opponent opponent;

    @BeforeEach
    void beforeEach() {
        opponent = new Opponent();
        opponent.createAnswer();
    }

    @Test
    @DisplayName("임의의 세 자릿수는 서로 중복되지 않은 1~9 사이의 값이어야 한다.")
    void create_answer_test() {
        // given when
        int[] answers = opponent.getAnswers();

        // then
        assertThat(answers.length).isEqualTo(3);

        for (int answer : answers)
            assertThat(answer).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);

        assertThat(answers[0]).isNotEqualTo(answers[1]).isNotEqualTo(0);
        assertThat(answers[0]).isNotEqualTo(answers[2]).isNotEqualTo(0);
        assertThat(answers[1]).isNotEqualTo(answers[2]).isNotEqualTo(0);
    }
}