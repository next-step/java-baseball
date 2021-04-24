package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballResultTest {

    @DisplayName("게임결과가 종료되지 않은 상태로 생성되는지 확인")
    @Test
    void initBaseResultTest() {
        BaseballResult baseballResult = new BaseballResult();
        assertFalse(baseballResult.isEndGame());
    }

    @DisplayName("1 스트라이크 상태 테스트")
    @Test
    void oneStrikeTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.strike();

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(1);
        assertThat(baseballResult.getBallCount()).isEqualTo(0);
    }

    @DisplayName("1 볼 상태 테스트")
    @Test
    void oneBallTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.ball();

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getBallCount()).isEqualTo(1);
        assertThat(baseballResult.getStrikeCount()).isEqualTo(0);
    }

    @DisplayName("2스트라이크 1 볼 상태 테스트")
    @Test
    void twoStrikeOneBallTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.strike();
        baseballResult.strike();
        baseballResult.ball();

        assertFalse(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(2);
        assertThat(baseballResult.getBallCount()).isEqualTo(1);
    }

    @DisplayName("3스트라이크 게임끝 상태 테스트")
    @Test
    void threeStrikeEndGameTest() {
        BaseballResult baseballResult = new BaseballResult();
        baseballResult.strike();
        baseballResult.strike();
        baseballResult.strike();

        assertTrue(baseballResult.isEndGame());
        assertThat(baseballResult.getStrikeCount()).isEqualTo(3);
    }

    @DisplayName("파울 상태 테스트")
    @Test
    void foulTest() {
        BaseballResult baseballResult = new BaseballResult();

        assertTrue(baseballResult.isFoul());
        assertFalse(baseballResult.isEndGame());
    }
}
