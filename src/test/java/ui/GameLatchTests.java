package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.exceptions.IllegalGameLatchFlagException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameLatchTests {
    @DisplayName("게임 종료, 시작 플래그 외에 다른 값으로 Latch 종료 여부를 판단하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = { "a", "b", "ndakln", "3", " " })
    void judgeKeepGoingFailTest(String invalidFlag) {
        GameLatch gameLatch = GameLatch.of();

        assertThatThrownBy(() -> gameLatch.judgeKeepGoing(invalidFlag))
                .isInstanceOf(IllegalGameLatchFlagException.class);
    }
}
