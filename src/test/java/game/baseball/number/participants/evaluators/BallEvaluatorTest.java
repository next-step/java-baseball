package game.baseball.number.participants.evaluators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallEvaluatorTest {

    @ParameterizedTest
    @DisplayName("0 볼 체크")
    @ValueSource(strings = {"456", "789", "123"})
    void testZeroBallReturnTrue(String input) {
        final String given = "123";

        Evaluator ballEvaluator = new BallEvaluator();
        assertEquals(0, ballEvaluator.evaluate(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("1 볼 체크")
    @ValueSource(strings = {"345", "367", "819", "289"})
    void testOneBallReturnFalse(String input) {
        final String given = "123";

        Evaluator ballEvaluator = new BallEvaluator();
        assertEquals(1, ballEvaluator.evaluate(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("3 볼 체크")
    @ValueSource(strings = {"312"})
    void testThreeBallReturnFalse1(String input) {
        final String given = "123";

        Evaluator ballEvaluator = new BallEvaluator();
        assertEquals(3, ballEvaluator.evaluate(given, input), "input: " + input);
    }

    @ParameterizedTest
    @DisplayName("3 볼 체크")
    @ValueSource(strings = {"936"})
    void testThreeBallReturnFalse2(String input) {
        final String given = "369";

        Evaluator ballEvaluator = new BallEvaluator();
        assertEquals(3, ballEvaluator.evaluate(given, input), "input: " + input);
    }
}
