import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InternalGameTest {

    @Test
    void getStrikeCount() {
        InternalGame internalGame = new InternalGame();
        assertEquals(internalGame.getStrikeCount(new GameInfo("123"), new GameInfo("123")), 3);
        assertEquals(internalGame.getStrikeCount(new GameInfo("123"), new GameInfo("423")), 2);
        assertEquals(internalGame.getStrikeCount(new GameInfo("123"), new GameInfo("453")), 1);
        assertEquals(internalGame.getStrikeCount(new GameInfo("123"), new GameInfo("456")), 0);
    }
}