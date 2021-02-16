package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallCountTest {

    @DisplayName("볼, 스트라이크가 같으면 동일 객체")
    @Test
    void testEquals() {
        // given & when
        BallCount ballCount1 = new BallCount(1, 1);
        BallCount ballCount2 = new BallCount(1, 1);

        // then
        assertThat(ballCount1).isEqualTo(ballCount2);
    }
}