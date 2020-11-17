package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallCountTest {

    @DisplayName("생성(낫싱) : 0 스트라이크 0 볼")
    @Test
    void 생성() {
        // given/when
        BallCount ballCount = new BallCount();

        // then
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=0, ball=0]");

        assertThat(ballCount.isNothing()).isTrue();

        assertThat(ballCount.getCurrent()).isEqualTo("낫싱");
    }

    @DisplayName("볼카운트 String 반환: 1 스트라이크")
    @Test
    void getCurrent_1_스트라이크() {
        // given
        BallCount ballCount = new BallCount();

        // when
        ballCount.addStrike();
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=1, ball=0]");

        // then
        assertThat(ballCount.getCurrent()).isEqualTo("1 스트라이크 ");
    }

    @DisplayName("볼카운트 String 반환: 1 볼")
    @Test
    void getCurrent_1_볼() {
        // given
        BallCount ballCount = new BallCount();

        // when
        ballCount.addBall();
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=0, ball=1]");

        // then
        assertThat(ballCount.getCurrent()).isEqualTo("1 볼");
    }

    @DisplayName("볼카운트 String 반환: 1 스트라이크 1 볼")
    @Test
    void getCurrent_1_스트라이크_1_볼() {
        // given
        BallCount ballCount = new BallCount();

        // when
        ballCount.addStrike();
        ballCount.addBall();
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=1, ball=1]");

        // then
        assertThat(ballCount.getCurrent()).isEqualTo("1 스트라이크 1 볼");
    }

    @DisplayName("승리조건 : 3 스트라이크 (승리)")
    @Test
    void 승리조건() {
        // given
        BallCount ballCount = new BallCount();

        // when
        ballCount.addStrike();
        ballCount.addStrike();
        ballCount.addStrike();
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=3, ball=0]");

        // then
        assertThat(ballCount.isAllStrike()).isTrue();
    }

    @DisplayName("초기화(낫싱): 0 스트라이크 0 볼")
    @Test
    void 초기화() {
        // given
        BallCount ballCount = new BallCount();

        // when
        ballCount.addStrike();
        ballCount.addBall();
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=1, ball=1]");
        ballCount.clear();

        // then
        assertThat(ballCount.toString())
                .isEqualTo("BallCount [strike=0, ball=0]");
    }
}