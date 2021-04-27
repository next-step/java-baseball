import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    BaseBallGame game;

    @BeforeEach
    void setUp() {
        game = new BaseBallGame();
    }

    @Test
    void answerGenerationTest() {
        game.generateAnswer();

        assertTrue(game.answer.length == 3);
    }
}