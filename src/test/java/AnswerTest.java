import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    @Test
    public void test(){
        Answer at = new Answer();
        String answer = at.answer;
        assertTrue(at.isCorrect(answer));
    }
}