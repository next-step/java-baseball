package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IncrementsNumberTest {
    @Test
    void value() {
        IncrementsNumber incrementsNumber = new IncrementsNumber();

        assertThat(incrementsNumber.value()).isEqualTo(1);
        assertThat(incrementsNumber.value()).isEqualTo(2);
        assertThat(incrementsNumber.value()).isEqualTo(3);
    }
}