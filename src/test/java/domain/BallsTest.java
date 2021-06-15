package domain;

import domain.exception.BallsDuplicatedNumberException;
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
    @DisplayName("볼 목록 생성 시 중복된 숫자가 존재할 경우 예외처리 한다.")
    public void test0() {
        int ballSize = Rule.ballSize();

        List<Ball> ballList = Arrays.asList(
                new Ball(BallNumber.valueOf(1), BallPosition.valueOf(0)),
                new Ball(BallNumber.valueOf(2), BallPosition.valueOf(1)),
                new Ball(BallNumber.valueOf(3), BallPosition.valueOf(2))
        );

        Balls balls = new Balls(ballList);

        assertThat(balls.size()).isEqualTo(ballSize);
    }

    @Test
    @DisplayName("볼 컬렉션 > 사이즈 불일치 테스트")
    public void test1() {
        assertThatThrownBy(() -> {
        });
    }
}
