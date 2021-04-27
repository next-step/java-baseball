import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    @ParameterizedTest
    @CsvSource({"123, true", "12, false"})
    void validateUserNumber(String input) {
        boolean isValid = game.validateUserInput(input);

        assertTrue(isValid);
    }
}