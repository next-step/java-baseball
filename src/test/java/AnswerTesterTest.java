import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTesterTest {
    @Test
    public void test(){
        AnswerTester at = new AnswerTester("123");
        assertEquals(at.getResult("628")[1], 1);
        assertEquals(at.getResult("123")[1], 3);
        assertEquals(at.getResult("213")[0], 2);
        assertEquals(at.getResult("213")[1], 1);
    }
}