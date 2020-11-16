import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    /**
     * 랜덤한 3개숫자로 이루어진 문자열 생성 테스트
     */
    @Test
    public void testGetQuestionNumber() {
        Question question = new Question();
        String result = question.generate();
        System.out.println("questionNumber: " + result);

        assertTrue(result != null);
    }
}
