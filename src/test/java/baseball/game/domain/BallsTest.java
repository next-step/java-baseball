package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import baseball.game.exception.BallsSizeException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    @DisplayName("3개의 공을 생성한 값이 일치한지")
    void create_balls() {
        List<Ball> ballList = new ArrayList<>();

        Ball firstBall = new Ball(6);
        Ball secondBall = new Ball(9);
        Ball thirdBall = new Ball(1);

        ballList.add(firstBall);
        ballList.add(secondBall);
        ballList.add(thirdBall);

        Balls balls = Balls.create(ballList);

        assertThat(balls.getBall(0)).isEqualTo(firstBall);
        assertThat(balls.getBall(1)).isEqualTo(secondBall);
        assertThat(balls.getBall(2)).isEqualTo(thirdBall);
    }

    @Test
    @DisplayName("공의 사이즈가 3보다 작을 경우")
    void throwException_minSizeBalls() {
        List<Ball> ballList = new ArrayList<>();

        Ball firstBall = new Ball(6);
        Ball secondBall = new Ball(9);

        ballList.add(firstBall);
        ballList.add(secondBall);

        assertThatExceptionOfType(BallsSizeException.class)
            .isThrownBy(() -> Balls.create(ballList));
    }

    @Test
    @DisplayName("공의 사이즈가 3보다 클 경우")
    void throwException_maxSizeBalls() {
        List<Ball> ballList = new ArrayList<>();

        Ball firstBall = new Ball(6);
        Ball secondBall = new Ball(9);
        Ball thirdBall = new Ball(1);
        Ball fourthBall = new Ball(1);

        ballList.add(firstBall);
        ballList.add(secondBall);
        ballList.add(thirdBall);
        ballList.add(fourthBall);

        assertThatExceptionOfType(BallsSizeException.class)
            .isThrownBy(() -> Balls.create(ballList));
    }
}