package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {
    @DisplayName("초기화한 숫자야구 게임의 초기 상태는 종료되지 않은 상태이다")
    @Test
    void initialize() {
        BaseBallGame baseBallGame = BaseBallGame.initialize(new Opponent(new OneTwoThreeGenerator()));

        assertThat(baseBallGame.isEnd()).isFalse();
    }
}
