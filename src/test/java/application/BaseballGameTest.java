package application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    @Test
    @DisplayName("UI 테스트")
    public void test() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.run();
    }
}