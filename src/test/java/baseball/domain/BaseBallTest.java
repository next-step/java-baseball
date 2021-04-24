package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BaseBallTest {
    @Test
    void create() {
        assertThatCode(() -> BaseBall.of(Arrays.asList(Ball.of(1), Ball.of(5), Ball.of(9)))).doesNotThrowAnyException();
    }
}
