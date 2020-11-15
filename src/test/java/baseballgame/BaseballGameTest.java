package baseballgame;

import org.assertj.core.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();

    @DisplayName("초기화 후 게임 넘버 validation 체크")
    @Test
    void gameNumberCheckIsAllNumber() {
        baseballGame.initGame();
        String gameNumber = baseballGame.getGameNumber();
        Assertions.assertThat(gameNumber).isNotEmpty();
        Assertions.assertThat(gameNumber.length()).isEqualTo(3);
        for (char c : gameNumber.toCharArray()) {
            assertTrue(Character.isDigit(c));
        }
    }
}
