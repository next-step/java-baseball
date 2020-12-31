import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameHostTest {

    @Test
    void isValid() {
        GameHost gameHost = new GameHost();
        assertEquals(gameHost.isValid("425"), true);
        assertEquals(gameHost.isValid("8280"), false);
    }

    @Test
    void isUniqueEach() {
        GameHost gameHost = new GameHost();
        assertEquals(gameHost.isUniqueEach("629"), true);
        assertEquals(gameHost.isUniqueEach("226"), false);
    }
}