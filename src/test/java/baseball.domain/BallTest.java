package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    public void validationOverCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Ball.of(5);
        });
    }

    @Test
    public void validationUnderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Ball.of(-1);
        });
    }
    @Test
    public void ballCountCheck() {
        assertThat(Ball.of(2).toString()).isEqualTo("2");
    }
}
