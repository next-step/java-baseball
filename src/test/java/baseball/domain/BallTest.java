package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class BallTest {
    @Test
    void create() {
        assertThatCode(() -> Ball.of(0)).doesNotThrowAnyException();
    }
}
