package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberTest {
    @Test
    void value() {
        for (int i = 0; i < 10000; i++) {
            assertThat(new RandomNumber().value()).isBetween(1, 9);
        }
    }
}