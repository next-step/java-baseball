package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNoTest {
    @Test
    @DisplayName("IllegalArgumentException test")
    public void underTheOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNo.of(0);
        });
    }

    @Test
    @DisplayName("IllegalArgumentException test")
    public void overTheNine() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNo.of(10);
        });
    }

}
