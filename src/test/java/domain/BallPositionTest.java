package domain;

import domain.exception.BallPositionNotValidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallPositionTest {
    @Test
    @DisplayName("볼 위치 생성 시 음수 입력하면 예외처리 한다.")
    public void test() {
        assertThatThrownBy(() -> {
            BallPosition.valueOf(-1);
        }).isExactlyInstanceOf(BallPositionNotValidRangeException.class)
                .hasMessage(BallPositionNotValidRangeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 위치 생성 시 0을 입력하면 예외처리 한다.")
    public void test0() {
        assertThatThrownBy(() -> {
            BallPosition.valueOf(0);
        }).isExactlyInstanceOf(BallPositionNotValidRangeException.class)
                .hasMessage(BallPositionNotValidRangeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 위치 생성 시 최대값(3) 이상을 입력하면 예외처리 한다.")
    public void test1() {
        assertThatThrownBy(() -> {
            BallPosition.valueOf(4);
        }).isExactlyInstanceOf(BallPositionNotValidRangeException.class)
                .hasMessage(BallPositionNotValidRangeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 위치 생성 시 1~3 사이 값을 입력하면 정상적으로 생성된다.")
    public void test2() {
        for (int position = BallPosition.MIN_BALL_POSITION; position < BallPosition.MAX_BALL_POSITION; position++) {
            BallPosition ballPosition = BallPosition.valueOf(position);
            assertThat(position).isEqualTo(ballPosition.position());
        }
    }
}