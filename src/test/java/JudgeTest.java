import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JudgeTest {
    Judge judge = new Judge();

    @Test
    public void getResultTest() {
        assertTrue(judge.getResult(123, 456).equals(new Result(0, 0)));
        assertTrue(judge.getResult(123, 321).equals(new Result(1, 2)));
        assertTrue(judge.getResult(381, 248).equals(new Result(0, 1)));
        assertTrue(judge.getResult(179, 179).equals(new Result(3, 0)));
    }
}
