import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberEvaluatorTest {
    BaseballNumberEvaluator evaluator;

    @BeforeEach
    void init() {
        evaluator = new BaseballNumberEvaluator();
    }

    @Test
    @DisplayName("두 숫자가 일치할 경우 isSuccess 가 true를 반환해야 한다")
    void testSuccessCase() {
        EvaluationResult result = evaluator.evaluate("123", "123");
        assertTrue(result.getSuccess());
    }

    @Test
    @DisplayName("두 숫자가 서로 다른위치에 같은 숫자셋을 가질 경우 3 볼을 반환해야 한다")
    void test3Balls() {
        EvaluationResult result = evaluator.evaluate("123", "231");
        assertEquals(3, result.getBalls());
    }

    @Test
    @DisplayName("두 숫자가 123, 321 은 1 스트라이크, 2 볼을 반환해야 한다")
    void test1Strike2Balls() {
        EvaluationResult result = evaluator.evaluate("123", "321");
        assertEquals(2, result.getBalls());
        assertEquals(1, result.getStrikes());
    }

}