package baseball.opponent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Map;

import static baseball.opponent.Opponent.ResultType;
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

    @Test
    @DisplayName("수와 자리 모두 2개가 같을 경우 2 스트라이크를 반환한다.")
    void compare_two_strike_test() {
        // given
        int[] answers = opponent.getAnswers();

        int answer1 = answers[0] * 100;
        int answer2 = answers[1] * 10;
        int wrongAnswer = getNonDuplicatedValue(answers);

        int answer = answer1 + answer2 + wrongAnswer;

        // when
        Map<ResultType, Integer> compare = opponent.compare(answer);

        // then
        assertThat(compare.get(ResultType.STRIKE)).isEqualTo(2);
        assertThat(compare).doesNotContainKey(ResultType.BALL);
        assertThat(compare).doesNotContainKey(ResultType.NOTHING);
    }

    @Test
    @DisplayName("수와 자리가 1개, 수는 2개 같지만 자리가 다를 경우 1 스트라이크 2 볼을 반환한다.")
    void compare_one_strike_two_ball_test() {
        // given
        int[] answers = opponent.getAnswers();

        int changed3answer1 = answers[2] * 100;
        int answer2 = answers[1] * 10;
        int changed1answer3 = answers[0];

        int answer = changed3answer1 + answer2 + changed1answer3;

        // when
        Map<ResultType, Integer> compare = opponent.compare(answer);

        // then
        assertThat(compare.get(ResultType.STRIKE)).isEqualTo(1);
        assertThat(compare.get(ResultType.BALL)).isEqualTo(2);
        assertThat(compare).doesNotContainKey(ResultType.NOTHING);
    }

    @Test
    @DisplayName("같은 값이 하나도 없으면 낫싱을 반환한다.")
    void compare_nothing_test() {
        // given
        int[] answers = opponent.getAnswers();

        int answer1 = getNonDuplicatedValue(answers) * 100;
        int checkAnswer1 = answer1 / 100;

        int answer2 = getNonDuplicatedValue(answers, checkAnswer1) * 10;
        int checkAnswer2 = answer2 / 10;

        int answer3 = getNonDuplicatedValue(answers, checkAnswer1, checkAnswer2);

        int wrongAnswer = answer1 + answer2 + answer3;

        // when
        Map<ResultType, Integer> compare = opponent.compare(wrongAnswer);

        // then
        assertThat(compare).containsKey(ResultType.NOTHING);
        assertThat(compare).doesNotContainKey(ResultType.STRIKE);
        assertThat(compare).doesNotContainKey(ResultType.BALL);
    }

    private int getNonDuplicatedValue(int[] answers, int... addedAnswer) {
        int random = (int) (Math.random() * 9) + 1;

        // 배열을 정렬 위한 얕은 복사
        int[] tempAnswers = Arrays.copyOf(answers, 10);

        // 추가 된 값도 중복 검사에 포함시키기 위해 tempAnswers에 추가
        System.arraycopy(addedAnswer, 0, tempAnswers, 3, addedAnswer.length);

        // binarySearch 하기 위한 정렬
        Arrays.sort(tempAnswers);

        // random 값이 배열에 있으면 재귀 호출로 random 값 재생성
        if (Arrays.binarySearch(tempAnswers, random) >= 0)
            return getNonDuplicatedValue(answers, addedAnswer);

        // 중복되지 않은 random 값 반환
        return random;
    }

}