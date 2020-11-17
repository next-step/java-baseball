package game.baseball.number.participants.evaluators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StrikeEvaluatorTest {

    @ParameterizedTest
    @DisplayName("1 스트라이크 체크 false")
    @ValueSource(strings = {"145", "426", "563"})
    void testOneStrikeReturnFalse(String input) {
        final String given = "123";
        Evaluator strikeEvaluator = new StrikeEvaluator();

        assertFalse(strikeEvaluator.test(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("2 스트라이크 체크 false")
    @ValueSource(strings = {"124", "423", "183"})
    void testTwoStrikeReturnFalse(String input) {
        final String given = "123";
        Evaluator strikeEvaluator = new StrikeEvaluator();

        assertFalse(strikeEvaluator.test(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("3 스트라이크 체크 true")
    @ValueSource(strings = {"123"})
    void testThreeStrikeReturnFalse1(String input) {
        final String given = "123";
        Evaluator strikeEvaluator = new StrikeEvaluator();

        assertTrue(strikeEvaluator.test(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("3 스트라이크 체크 true")
    @ValueSource(strings = {"457"})
    void testThreeStrikeReturnFalse2(String input) {
        final String given = "457";
        Evaluator strikeEvaluator = new StrikeEvaluator();

        assertTrue(strikeEvaluator.test(given, input), "input: " + input);
    }
}
