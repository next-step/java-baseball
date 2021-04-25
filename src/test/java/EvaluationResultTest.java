import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationResultTest {
    EvaluationResult result;
    @BeforeEach
    void init() {
        result = new EvaluationResult();
    }
    @DisplayName("increaseBall 을 호출하면 볼이 하나 증가 해야 함")
    @Test
    void testIncreaseBall() {
        result.increaseBall();
        assertEquals(1, result.getBalls());
    }

    @DisplayName("increaseStrike 을 호출하면 스트라이크가 하나 증가 해야 함")
    @Test
    void testIncreaseStrike() {
        result.increaseStrike();
        assertEquals(1, result.getStrikes());
    }

    @DisplayName("success 처리하면 스트라이크가 3이되고 isSuccess 가 true여야 한다")
    @Test
    void testSuccessResult() {
        result.success();
        assertEquals(3, result.getStrikes());
        assertEquals(0, result.getBalls());
        assertTrue(result.getSuccess());
    }



}