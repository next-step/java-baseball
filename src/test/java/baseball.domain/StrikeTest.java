package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeTest {
    @Test
    public void validationOverCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Strike.of(5);
        });
    }

    @Test
    public void validationUnderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Strike.of(-1);
        });
    }
    @Test
    public void ballCountCheck() {
        assertThat(Strike.of(2).toString()).isEqualTo("2");
    }
}
