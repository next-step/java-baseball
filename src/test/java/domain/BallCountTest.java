package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BallCountTest {

    @DisplayName("카운트가 리셋이 되는지 확인한다.")
    @Test
    void resetCount() {
        BallCount ballCount = new BallCount(1, 2);
        ballCount.resetCount();
        assertThat(ballCount.toString()).hasToString("낫싱");
    }

    @DisplayName("숫자가 스트라이크인지 확인한다.")
    @Test
    void isStrike() {
        BallCount ballCount = new BallCount();
        ballCount.isStrike(Number.of(2), Number.of(2));
        assertThat(ballCount.toString()).hasToString("1스트라이크");
    }

    @DisplayName("숫자가 볼인지 확인한다.")
    @Test
    void isBall() {
        BallCount ballCount = new BallCount();
        ballCount.isBall(BallNumbers.of("234"), Number.of(2), Number.of(3));
        assertThat(ballCount.toString()).hasToString("1볼");
    }

    @DisplayName("게임이 끝났는지 확인한다.")
    @Test
    void isDone() {
        BallCount ballCount = new BallCount(3, 0);
        assertThat(ballCount.isDone(3)).isTrue();
    }
}