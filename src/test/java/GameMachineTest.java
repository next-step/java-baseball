import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class GameMachineTest {

    @Test
    @DisplayName("GameMachine 생성 테스트")
    void createGameMachineTest() {
        GameMachine gameMachine = GameMachine.of();
        assertNotEquals(null, gameMachine);
        assertEquals(0, gameMachine.getCurrentRandomSetSize());
    }
}