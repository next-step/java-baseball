import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {
    @Test
    public void equalsTest() {
        Result result1 = new Result(2, 1);
        Result result2 = new Result(1, 0);
        assertFalse(result1.equals(result2));

        result1 = new Result(1, 0);
        assertTrue(result1.equals(result2));
    }
}
