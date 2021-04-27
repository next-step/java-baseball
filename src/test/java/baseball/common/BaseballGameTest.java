package baseball.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    BaseballGame game;

    @BeforeEach
    void setUp() {
        game = new BaseballGame();
    }

    @DisplayName("ball과 strike 값이 초기화 되는지 테스트")
    @Test
    void initHintTest() {
        game.initHint();
        assertThat(game.ball).isEqualTo(0);
        assertThat(game.strike).isEqualTo(0);
    }

    @DisplayName("랜덤 생성된 수와 입력된 수에 따른 결과 메세지 테스트")
    @ParameterizedTest(name="{index}=>random={0},input={1},expected={2}")
    @CsvSource({
            "123,123,3스트라이크",
            "123,111,1스트라이크 2볼",
            "123,456,낫싱"})
    void compareInputTest(String random, String input, String expected) {
        game.initHint();
        assertThat(game.compareInput(random, input)).isEqualTo(expected);
    }

    @DisplayName("3 스트라이크일 경우 true 반환하는지 테스트")
    @Test
    void isFinish() {
        game.strike = 3;
        assertThat(game.isFinish()).isTrue();
    }
}