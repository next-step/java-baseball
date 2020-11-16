import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {

    String questionNumber = "425";

    /**
     * 3자리 숫자가 아닌경우 => 1자리숫자만 입력한 경우
     */
    @DisplayName("3자리 숫자가 아닌 경우")
    @Test
    public void testIsVaild1() {
        Answer answer = new Answer(questionNumber);
        boolean result = answer.isValid("1");
        assertEquals(result, false);
    }

    /**
     * 3자리 숫자가 아닌경우 => 2자리숫자만 입력한 경우
     */
    @DisplayName("3자리 숫자가 아닌 경우")
    @Test
    public void testIsVaild2() {
        Answer answer = new Answer(questionNumber);
        boolean result = answer.isValid("12");
        assertEquals(result, false);
    }

    /**
     * 정담을 맞출 경우
     */
    @DisplayName("3볼인 경우")
    @Test
    public void testIs3Ball() {
        Answer answer = new Answer(questionNumber);
        answer.getBallCount("254");

        assertEquals(answer.ballCount, 3);
    }
}
