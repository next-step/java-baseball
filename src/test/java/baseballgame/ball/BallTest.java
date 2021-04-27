package baseballgame.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("공의 범위에 맞는 1개를 생성한다.")
    void createBall_inRange_true(int number) {
        Ball ball = Ball.createBall(number);
        assertThat(ball.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {99999,8657,34124})
    @DisplayName("공의 범위에 맞지 않는 1개를 생성한다.")
    void createBall_outOfRange_fail(int number) {
        assertThatThrownBy(() -> {
            Ball ball = Ball.createBall(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}