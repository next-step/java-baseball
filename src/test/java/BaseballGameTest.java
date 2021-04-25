import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    BaseballNumberValidator validator;
    BaseballNumberGenerator generator;
    BaseballNumberEvaluator evaluator;
    BaseballGame game;

    @BeforeEach
    void init() {
        validator = new BaseballNumberValidator();
        generator = new BaseballNumberGenerator();
        evaluator = new BaseballNumberEvaluator();
        game = new BaseballGame(generator, validator, evaluator);
    }

    @Test
    @DisplayName("게임 생성 시 생성자의 argument 인 validator, generator, evalutor 는 null이면 안된다")
    void testIsValidConstructorArguments() {
        assertAll(
                () -> assertThrows(AssertionError.class, () -> new BaseballGame(null, new BaseballNumberValidator(), new BaseballNumberEvaluator())),
                () -> assertThrows(AssertionError.class, () -> new BaseballGame(new BaseballNumberGenerator(), null, new BaseballNumberEvaluator())),
                () -> assertThrows(AssertionError.class, () -> new BaseballGame(new BaseballNumberGenerator(), new BaseballNumberValidator(), null))
        );
    }

    @Test
    @DisplayName("처음 생성한 게임은 새 게임")
    void testIsNewGame() {
        assertTrue(game.isNewGame());
    }

    @Test
    @DisplayName("처음 생성한 게임은 반드시 새로운 베이스볼 숫자를 생성")
    void testIsNewGameGenerateBaseballNumber() {
        game.generateBaseBallNumber();
        assertNotNull(game.getBaseballNumber());
    }
}