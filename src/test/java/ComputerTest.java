import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    @Test
    public void nextTurnTest() {
        int turn = Computer.nextTurn();
        assertTrue(Check.validationCheck(turn));
    }
}
