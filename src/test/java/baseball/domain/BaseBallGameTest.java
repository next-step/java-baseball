package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {
    @DisplayName("초기화한 숫자야구 게임의 초기 상태는 종료되지 않은 상태이다")
    @Test
    void initialize() {
        BaseBallGame game = BaseBallGame.initialize(new Opponent(new OneTwoThreeGenerator()));

        boolean result = game.isEnd();

        assertThat(result).isFalse();
    }

    @DisplayName("게임 결과가 3 스트라이크일 경우 게임이 종료 상태로 바뀐다")
    @ParameterizedTest
    @CsvSource({"123,true", "243,false"})
    void end(String guess, boolean expected) {
        BaseBallGame game = BaseBallGame.initialize(new Opponent(new OneTwoThreeGenerator()));

        game.guess(BaseBallNumbers.from(guess));

        assertThat(game.isEnd()).isEqualTo(expected);
    }
}
