package game.baseball.number.participants.evaluators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallEvaluatorTest {

    @ParameterizedTest
    @DisplayName("0 볼 체크 true")
    @ValueSource(strings = {"456", "789", "123"})
    void testZeroBallReturnTrue(String input) {
        final String given = "123";

        Evaluator ballEvaluator = new BallEvaluator();
        assertTrue(ballEvaluator.test(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("1 볼 체크 false")
    @ValueSource(strings = {"345", "367", "819", "289"})
    void testOneBallReturnFalse(String input) {
        final String given = "123";

        Evaluator ballEvaluator = new BallEvaluator();
        assertFalse(ballEvaluator.test(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("3 볼 체크 false")
    @ValueSource(strings = {"312"})
    void testThreeBallReturnFalse1(String input) {
        final String given = "123";

        Evaluator ballEvaluator = new BallEvaluator();
        assertFalse(ballEvaluator.test(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("3 볼 체크 false")
    @ValueSource(strings = {"936"})
    void testThreeBallReturnFalse2(String input) {
        final String given = "369";

        Evaluator ballEvaluator = new BallEvaluator();
        assertFalse(ballEvaluator.test(given, input), "input: " + input);
    }
}
