package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Computer Test")
public class ComputerTest {

    @DisplayName("init Computer Test")
    @Test
    public void initComputerTest(){
        Computer computer = new Computer();
        assertNotNull(computer);
        assertNotNull(computer.getBallNumber());
    }

}
