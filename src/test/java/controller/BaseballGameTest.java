package controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    private static BaseballGame baseballGame;
    @BeforeAll
    static void init() {
        baseballGame = new BaseballGame();

    }
    @Test
    void 에러체크() {
         baseballGame.start();

    }
}
