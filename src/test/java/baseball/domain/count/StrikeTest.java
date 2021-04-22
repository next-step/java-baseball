package baseball.domain.count;

import baseball.domain.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {
    private Numbers randomNumbers = new Numbers("5", "8", "3");

    @Test
    void strikeCountTest() {
        assertThat(new Strike().count(randomNumbers, new Numbers("1", "2", "3")))
                .isEqualTo(1);
        assertThat(new Strike().count(randomNumbers, new Numbers("8", "5", "3")))
                .isEqualTo(1);
        assertThat(new Strike().count(randomNumbers, new Numbers("5", "2", "3")))
                .isEqualTo(2);
        assertThat(new Strike().count(randomNumbers, new Numbers("5", "8", "3")))
                .isEqualTo(3);
    }
}
