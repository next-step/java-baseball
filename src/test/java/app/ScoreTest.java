package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    private final Score score = new Score();

    @BeforeEach
    void setUp() {
        score.clearCount();
    }

    @Test
    @DisplayName("스트라이크 카운트 테스트")
    void strikes() {
        score.setStrike();
        score.setStrike();

        assertThat(score.strikes()).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 카운트 테스트")
    void balls() {
        score.setBall();
        score.setBall();
        score.setBall();

        assertThat(score.balls()).isEqualTo(3);

    }

    @Test
    @DisplayName("카운트 클리어 테스트")
    void clearCount() {
        score.clearCount();

        assertThat(score.balls()).isEqualTo(0);
        assertThat(score.strikes()).isEqualTo(0);
    }

    @Test
    @DisplayName("게임 상태정보 확인(1스트라이크 1볼)")
    void getStatusTrue() {
        score.setStrike();
        score.setBall();

        assertThat(score.getStatus()).isTrue();
    }

    @Test
    @DisplayName("게임 상태정보 확인(3스트라이크. 게임 종료)")
    void getStatusFalse() {
        score.setStrike();
        score.setStrike();
        score.setStrike();

        assertThat(score.getStatus()).isFalse();
    }

    @Test
    @DisplayName("게임 결과 메시지 테스트")
    void getResultMessage() {
        score.setBall();
        score.setBall();
        score.setStrike();

        assertThat(score.getResultMessage()).isEqualTo("1 스트라이크 2 볼");
    }
}