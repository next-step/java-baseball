package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JudgmentTest {

    Ball catcherBall = new Ball(Arrays.asList(1,9,5));

    @Test
    @DisplayName("낫싱")
    void baseball_nothing() {
        Ball playerBall = new Ball(Arrays.asList(2,3,7));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 0);
        assertTrue(Judgment.BALL.count == 0);
        assertTrue(Judgment.NOTHING.count == 3);
    }

    @Test
    @DisplayName("3 스트라이크")
    void baseball_three_strike() throws Exception {
        Ball playerBall = new Ball(Arrays.asList(1,9,5));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 3);
        assertTrue(Judgment.BALL.count == 0);
    }

    @Test
    @DisplayName("2 스트라이크")
    void baseball_two_strike() throws Exception {

        Ball playerBall = new Ball(Arrays.asList(1,3,5));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 2);
        assertTrue(Judgment.BALL.count == 0);
    }

    @Test
    @DisplayName("1 스트라이크 2 볼")
    void baseball_one_strike_two_ball() throws Exception {

        Ball playerBall = new Ball(Arrays.asList(1,5,9));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 1);
        assertTrue(Judgment.BALL.count == 2);
    }

    @Test
    @DisplayName("1 스트라이크 1 볼")
    void baseball_one_strike_one_ball() throws Exception {

        Ball playerBall = new Ball(Arrays.asList(8,9,1));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 1);
        assertTrue(Judgment.BALL.count == 1);
    }

    @Test
    @DisplayName("3 볼")
    void baseball_three_ball() throws Exception {
        Ball playerBall = new Ball(Arrays.asList(5,1,9));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 0);
        assertTrue(Judgment.BALL.count == 3);
    }

    @Test
    @DisplayName("2 볼")
    void baseball_two_ball() throws Exception {
        Ball playerBall = new Ball(Arrays.asList(5,1,3));

        Judgment.judge(catcherBall, playerBall);

        assertTrue(Judgment.STRIKE.count == 0);
        assertTrue(Judgment.BALL.count == 2);
    }
}
