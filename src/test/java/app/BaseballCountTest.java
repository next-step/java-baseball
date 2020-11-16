package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballCountTest {

    @Test
    @DisplayName("BaseballCount enum value 확인")
    void getValue() {
        assertThat("스트라이크").isEqualTo(BaseballCount.STRIKE.getValue());
    }
}