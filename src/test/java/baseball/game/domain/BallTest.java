package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import baseball.game.exception.BallNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    @DisplayName("두개의 공이 같은 공인지")
    void equals_twoBalls() {
        Ball ball1 = Ball.of(1);
        Ball ball2 = Ball.of(1);

        assertThat(ball1).isEqualTo(ball2);

    }

    @Test
    @DisplayName("공의 숫자가 1보다 작을 경우 오류 발생")
    void throwException_minNumberBall() {
        assertThatExceptionOfType(BallNumberRangeException.class)
            .isThrownBy(() -> Ball.of(0));
    }

    @Test
    @DisplayName("공의 숫자가 9보다 클 경우 오류 발생")
    void throwException_maxNumberBall() {
        assertThatExceptionOfType(BallNumberRangeException.class)
            .isThrownBy(() -> Ball.of(10));
    }
}