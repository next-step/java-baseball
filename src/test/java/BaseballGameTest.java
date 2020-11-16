import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballGameTest {

    private static BaseballGame game;

    @BeforeAll
    static void setup() {
        game = new BaseballGame();
        game.start();
    }


    /**
     * 정답확인여부
     */
    @Test
    public void testAnswer() {
        boolean result = game.answer("123");

        assertTrue(result);
    }

}
