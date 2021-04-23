package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    @DisplayName("볼 허용 범위가 0~3을 벗어나면 IllegalArgumentException를 리턴한다.")
    public void validationOverBall() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Ball.of(4);
        });
    }

    @Test
    @DisplayName("볼 점수가 맞는지 비교한다.")
    public void ballCheck() {
        assertThat(Ball.of(2).toString()).isEqualTo("2");
    }
}