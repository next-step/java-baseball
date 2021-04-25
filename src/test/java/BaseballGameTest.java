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
    @DisplayName("게임 생성 시 생성자의 argument 인 validator, generator, evaluator 는 null 이면 안된다")
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

    @Test
    @DisplayName("게임 결과 확인 후에는 정상적인 결과를 반환해야 한다")
    void testValidHintText() {
        // 1 스트라이크 2 볼
        game.setBaseballNumber("123");
        game.setInputNumber("123");
        game.evaluate();
        // 메시지 결과
        assertEquals("3 스트라이크 ", game.getResultMessage());
        assertTrue(game.isSuccess());
    }

    @Test
    @DisplayName("일치하지 않을 경우 낫싱을 출력해야 한다")
    void testValidHintTextWhenOut() {
        // 1 스트라이크 2 볼
        game.setBaseballNumber("123");
        game.setInputNumber("456");
        game.evaluate();
        // 메시지 결과
        assertEquals("낫싱", game.getResultMessage());
    }


}