package baseball.domain.count;

import baseball.domain.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Numbers randomNumbers = new Numbers("5", "8", "3");

    @Test
    void ballCountTest() {
        assertThat(new Ball().count(randomNumbers, new Numbers("1", "2", "3")))
                .isEqualTo(0);
        assertThat(new Ball().count(randomNumbers, new Numbers("5", "2", "3")))
                .isEqualTo(0);
        assertThat(new Ball().count(randomNumbers, new Numbers("5", "8", "3")))
                .isEqualTo(0);
        assertThat(new Ball().count(randomNumbers, new Numbers("8", "9", "1")))
                .isEqualTo(1);
        assertThat(new Ball().count(randomNumbers, new Numbers("8", "5", "3")))
                .isEqualTo(2);
    }
}
