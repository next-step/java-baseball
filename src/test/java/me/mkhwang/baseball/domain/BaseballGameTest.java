package me.mkhwang.baseball.domain;

import me.mkhwang.baseball.type.GameType;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/04/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
class BaseballGameTest {

    ByteArrayInputStream bindData;
    //Scanner를 테스트 하기위한 method
    private void provideInput(String data) {
        bindData = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        System.setIn(bindData);
    }

    @Test
    void endGame_test() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.endGame();
        assertEquals(GameType.GAME_END, baseballGame.getStatus());
    }

    @Test
    void gameEnd_test() {
        provideInput("2");
        BaseballGame baseballGame = new BaseballGame();
        BallCounter ballCounter = new BallCounter("123","123");
        ballCounter.printMessage();
        baseballGame.restartGame(ballCounter);
        assertEquals(GameType.GAME_END, baseballGame.getStatus());
    }

    @Test
    void restart_test() {
        provideInput("1");
        BaseballGame baseballGame = new BaseballGame();
        BallCounter ballCounter = new BallCounter("123","123");
        ballCounter.printMessage();
        baseballGame.restartGame(ballCounter);
        assertEquals(GameType.GAME_START, baseballGame.getStatus());
    }

}