package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Player Test")
public class PlayerTest {

    @DisplayName("init Player Test")
    @Test
    public void initPlayerTest() {
        Player player = new Player();
        BallNumber ballNumber = new BallNumber(123);
        player.setBallNumber(ballNumber);
        assertNotNull(player);
        assertNotNull(player.getBallNumber());
        assertTrue(Integer.parseInt(player.getBallNumber().toString()) == 123);
    }
}
