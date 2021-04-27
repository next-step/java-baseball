package domain;

import baseball.domain.Ball;
import baseball.domain.JudgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JudgeGameTest {
    private Ball comBall = new Ball(Arrays.asList(1, 2, 3));

    @Test
    @DisplayName("낫싱")
    void baseball_nothing() throws Exception {
        Ball userBall = new Ball(Arrays.asList(7, 8, 9));
        JudgeGame judgeGame = new JudgeGame();

        judgeGame.compareNum(comBall, userBall);
        assertTrue(judgeGame.isNothing());
    }

    @Test
    @DisplayName("1_ball")
    void baseball_1_b() throws Exception {
        Ball userBall = new Ball(Arrays.asList(7, 8, 1));
        JudgeGame judgeGame = new JudgeGame();

        judgeGame.compareNum(comBall, userBall);
        assertTrue(!judgeGame.isNothing());
        assertTrue(judgeGame.STRIKE_CNT == 0);
        assertTrue(judgeGame.BALL_CNT == 1);
    }

    @Test
    @DisplayName("2_ball")
    void baseball_2_b() throws Exception {
        Ball userBall = new Ball(Arrays.asList(7, 8, 1));
        JudgeGame judgeGame = new JudgeGame();

        judgeGame.compareNum(comBall, userBall);
        assertTrue(!judgeGame.isNothing());
        assertTrue(judgeGame.STRIKE_CNT == 0);
        assertTrue(judgeGame.BALL_CNT == 2);
    }

    @Test
    @DisplayName("1_strike_1_ball")
    void baseball_1_s_1_b() throws Exception {
        Ball userBall = new Ball(Arrays.asList(1, 3, 9));
        JudgeGame judgeGame = new JudgeGame();

        judgeGame.compareNum(comBall, userBall);
        assertTrue(!judgeGame.isNothing());
        assertTrue(judgeGame.STRIKE_CNT == 1);
        assertTrue(judgeGame.BALL_CNT == 1);
    }


    @Test
    @DisplayName("2_strike")
    void baseball_2_s() throws Exception {
        Ball userBall = new Ball(Arrays.asList(1, 2, 9));
        JudgeGame judgeGame = new JudgeGame();

        judgeGame.compareNum(comBall, userBall);
        assertTrue(!judgeGame.isNothing());
        assertTrue(judgeGame.STRIKE_CNT == 2);
        assertTrue(judgeGame.BALL_CNT == 0);
    }


    @Test
    @DisplayName("3_strike")
    void baseball_3_s() throws Exception {
        Ball userBall = new Ball(Arrays.asList(1, 2, 3));
        JudgeGame judgeGame = new JudgeGame();

        judgeGame.compareNum(comBall, userBall);
        assertTrue(!judgeGame.isNothing());
        assertTrue(judgeGame.STRIKE_CNT == 3);
        assertTrue(judgeGame.BALL_CNT == 0);
    }
}
