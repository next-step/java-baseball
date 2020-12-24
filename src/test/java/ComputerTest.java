import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    Computer computer = new Computer();

    @Test
    public void nextTurnTest() {
        int turn = computer.nextTurn();
        int sameDigitCounts = 0;

        if (turn / 100 == turn / 10 % 10) {
            sameDigitCounts++;
        }
        if (turn / 100 == turn % 10) {
            sameDigitCounts++;
        }
        if (turn / 10 % 10 == turn % 10) {
            sameDigitCounts++;
        }

        assertEquals(0, sameDigitCounts);
    }
}
