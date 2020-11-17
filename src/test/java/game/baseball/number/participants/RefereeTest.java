package game.baseball.number.participants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import game.baseball.number.exceptions.InvalidDifferentThreeNumberTypingException;
import game.baseball.number.participants.evaluators.Evaluators;
import game.baseball.number.validator.NumbersValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RefereeTest {

    @Test
    @DisplayName("Referee 객체 생성 성공")
    void testWithNonNull() {
        Referee referee = Referee.with(Evaluators.strikeEvaluator(), Evaluators.ballEvaluator(), new NumbersValidator());
        Assertions.assertNotNull(referee, "Referee is null");
    }

    @ParameterizedTest
    @DisplayName("랜덤 수 저장 throw")
    @ValueSource(strings = {"1", "a", "@", "#", "", " ", "   ", "  ", "a11", "abc", "11c", "111", "112", "000", "012"})
    void testSaveNumbersThrow(String input) {
        Referee referee = Referee.with(Evaluators.strikeEvaluator(), Evaluators.ballEvaluator(), new NumbersValidator());
        assertThatThrownBy(() -> referee.saveNumbers(input))
            .isInstanceOf(InvalidDifferentThreeNumberTypingException.class);
    }

    @ParameterizedTest
    @DisplayName("오답 false")
    @ValueSource(strings = {"124", "423", "183"})
    void testJudgeReturnFalse(String input) {
        String given = "123";

        Referee referee = Referee.with(Evaluators.strikeEvaluator(), Evaluators.ballEvaluator(), new NumbersValidator());
        referee.saveNumbers(given);
        assertFalse(referee.judge(input), "input" + input);
    }

    @ParameterizedTest
    @DisplayName("정답 true")
    @ValueSource(strings = {"123"})
    void testJudgeReturnTrue(String input) {
        String given = "123";

        Referee referee = Referee.with(Evaluators.strikeEvaluator(), Evaluators.ballEvaluator(), new NumbersValidator());
        referee.saveNumbers(given);
        assertTrue(referee.judge(input), "input" + input);
    }

    @ParameterizedTest
    @DisplayName("문제 없음 NPE throw")
    @ValueSource(strings = {"123"})
    void testJudgeThrowNPE(String input) {
        Referee referee = Referee.with(Evaluators.strikeEvaluator(), Evaluators.ballEvaluator(), new NumbersValidator());
        assertThatThrownBy(() -> referee.judge(input))
            .isInstanceOf(NullPointerException.class);
    }
}