import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    @Test
    @DisplayName("처음 생성한 게임은 무조건 새 게임")
    void testIsNewGame() {
        BaseballGame baseballGame = new BaseballGame();
        assertTrue(baseballGame.isNewGame());
    }

    @Test
    @DisplayName("처음 생성한 게임은 반드시 새로운 베이스볼 숫자를 생성")
    void testIsNewGameGenerateBaseballNumber() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.generateBaseBallNumber();
        assertNotNull(baseballGame.getBaseballNumber());
    }


}