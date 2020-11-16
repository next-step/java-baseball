package model.domain;

import exception.BaseballException;
import exception.ExceptionStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    void of_baseBallException_rowNumber() {
        assertThatThrownBy(() -> Ball.of(0))
                .isInstanceOf(BaseballException.class)
                .hasMessage(ExceptionStatus.INVALID_BALL_NUMBER.getMessage());
    }

    @Test
    void of() {
        Ball ball = Ball.of(1);

        assertThat(ball.getNumber()).isEqualTo(1);
    }

    @Test
    void of_baseBallException_highNumber() {
        assertThatThrownBy(() -> Ball.of(10))
                .isInstanceOf(BaseballException.class)
                .hasMessage(ExceptionStatus.INVALID_BALL_NUMBER.getMessage());
    }

    @Test
    void equals() {
        Ball ball = Ball.of(1);
        Ball compareBall = Ball.of(1);

        assertThat(ball.equals(compareBall)).isTrue();
    }
}
