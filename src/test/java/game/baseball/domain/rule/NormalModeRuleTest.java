package game.baseball.domain.rule;

import game.baseball.domain.Answer;
import game.baseball.domain.Ball;
import game.baseball.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NormalModeRuleTest {

    BaseballGameRule rule;

    @BeforeEach
    public void setup() {
        rule = new NormalModeRule();
    }

    @Test
    @DisplayName("게임 규칙 : 입력값 유효성 테스트 > 정상")
    void isValidInput() {
        // given
        String input = "123";

        // when
        boolean isValid = rule.isValidInput(input);

        // then
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("게임 규칙 : 입력값 유효성 테스트 > 실패_입력값의 길이가 틀린 경우")
    void isValidInputNotCorrectLengthTest() {
        // given
        String longLengthInput = "1234";

        // when
        boolean isValid = rule.isValidInput(longLengthInput);

        // then
        assertThat(isValid).isFalse();

        // given
        String shortLengthInput = "12";

        // when
        boolean isValid2 = rule.isValidInput(longLengthInput);

        // then
        assertThat(isValid2).isFalse();
    }

    @Test
    @DisplayName("게임 규칙 : 입력값 유효성 테스트 > 실패_중복된 입력값 존재하는 경우")
    void isValidInputDuplicatedInputExistTest() {
        // given
        String duplicatedInput = "111";

        // when
        boolean isValid = rule.isValidInput(duplicatedInput);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("게임 규칙 : 입력값 유효성 테스트 > 실패_숫자외 문자 존재하는 경우")
    void isValidInputOutOfDigitTest() {
        // given
        String notDigitInput = "12a";

        // when
        boolean isValid = rule.isValidInput(notDigitInput);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("게임 규칙 : 정답 생성 테스트")
    void generateAnswers() {
        // when
        Answer answer = rule.generateAnswers();

        // then
        assertThat(answer.getAnswers().size()).isEqualTo(3);

        for (Integer value : answer.getAnswers()) {
            assertThat(value).isBetween(rule.startBallNumber - '0', rule.endBallNumber - '0');
        }
    }

    @Test
    @DisplayName("게임 규칙 : 게임 성공 테스트")
    void isSuccess() {
        // given
        Result result = new Result();
        result.increaseStrike();
        result.increaseStrike();
        result.increaseStrike();

        // when
        boolean success = rule.isSuccess(result);

        // then
        assertThat(success).isTrue();
    }

    @Test
    @DisplayName("게임 규칙 : 스트라이크 규칙 테스트")
    void isStrike() {
        // given
        Ball ball = new Ball(1, 0);
        List<Integer> answers = Arrays.asList(1, 2, 3);

        // when
        boolean strikeYn = rule.isStrike(ball, answers);

        // then
        assertThat(strikeYn).isTrue();
    }

    @Test
    @DisplayName("게임 규칙 : 볼 규칙 테스트")
    void isBall() {
        // given
        Ball ball = new Ball(1, 1);
        List<Integer> answers = Arrays.asList(1, 2, 3);

        // when
        boolean ballYn = rule.isBall(ball, answers);

        // then
        assertThat(ballYn).isTrue();
    }

    @Test
    @DisplayName("게임 규칙 : All Strike 테스트")
    void isOut() {
        // given
        Result result = new Result();
        result.increaseStrike();
        result.increaseStrike();
        result.increaseStrike();

        // when
        boolean outYn = rule.isOut(result);

        // then
        assertThat(outYn).isTrue();
    }

    @Test
    @DisplayName("게임 규칙 : 낫싱 테스트")
    void isNothing() {
        // given
        Result result = new Result();

        // when
        boolean nothingYn = rule.isNothing(result);

        // then
        assertThat(nothingYn).isTrue();
    }
}