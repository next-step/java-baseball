package baseball.opponent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(ints = {99, 1000})
    @DisplayName("두 자릿수 또는 네 자릿수를 입력하면 예외가 발생한다.")
    void compare_input_answer_length_test(int answer) {
        // when then
        assertThatThrownBy(() -> opponent.compare(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자릿수를 입력해 주세요.");
    }

    @Test
    @DisplayName("0이 포함된 값을 입력하면 예외가 발생한다.")
    void compare_input_answer_zero_test() {
        // given
        int answer = 880;

        // when then
        assertThatThrownBy(() -> opponent.compare(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정답에 0이 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("중복된 값을 입력하면 예외가 발생한다.")
    void compare_input_answer_duplicate_test() {
        // given
        int answer = 777;

        // when then
        assertThatThrownBy(() -> opponent.compare(answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값을 입력할 수 없습니다.");
    }

}