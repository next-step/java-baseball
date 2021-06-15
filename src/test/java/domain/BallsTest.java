package domain;

import domain.exception.BallsDuplicatedNumberException;
import domain.exception.BallsDuplicatedPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {
    @Test
    @DisplayName("볼 목록 생성 시 중복된 숫자가 존재할 경우 예외처리 한다.")
    public void test() {
        List<Ball> ballList = Arrays.asList(
                new Ball(BallNumber.valueOf(1), BallPosition.valueOf(1)),
                new Ball(BallNumber.valueOf(1), BallPosition.valueOf(2)),
                new Ball(BallNumber.valueOf(2), BallPosition.valueOf(3))
        );

        assertThatThrownBy(() -> {
            Balls balls = new Balls(ballList);
        }).isExactlyInstanceOf(BallsDuplicatedNumberException.class)
                .hasMessage(BallsDuplicatedNumberException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 목록 생성 시 중복된 위치가 존재할 경우 예외처리 한다.")
    public void test2() {
        List<Ball> ballList = Arrays.asList(
                new Ball(BallNumber.valueOf(1), BallPosition.valueOf(1)),
                new Ball(BallNumber.valueOf(2), BallPosition.valueOf(1)),
                new Ball(BallNumber.valueOf(3), BallPosition.valueOf(2))
        );

        assertThatThrownBy(() -> {
            Balls balls = new Balls(ballList);
        }).isExactlyInstanceOf(BallsDuplicatedPositionException.class)
                .hasMessage(BallsDuplicatedPositionException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 목록 생성 정상 테스트")
    public void test0() {
        int ballSize = Rule.ballSize();

        List<Ball> ballList = Arrays.asList(
                new Ball(BallNumber.valueOf(1), BallPosition.valueOf(1)),
                new Ball(BallNumber.valueOf(2), BallPosition.valueOf(2)),
                new Ball(BallNumber.valueOf(3), BallPosition.valueOf(3))
        );

        Balls balls = new Balls(ballList);

        assertThat(balls.size()).isEqualTo(ballSize);
    }
}
