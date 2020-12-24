import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    Computer computer = new Computer();

    @Test
    public void nextTurnTest() {
        int turn = computer.nextTurn();
        Check check = new Check();

        assertTrue(check.validationCheck(turn));
    }
}
