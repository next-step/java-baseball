package game.baseball.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import game.baseball.number.exceptions.InvalidRestartOrExitInputException;
import game.baseball.number.status.GameProgressStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameProgressStatusTest {

    @ParameterizedTest
    @DisplayName("게임 재시작 또는 종료 입력 체크 시 예외 발생")
    @ValueSource(strings = {"", " ", "1 ", "2 ", " 1", " 2", " 1 ", " 2 ", "3", "4", "11", "111", "a", "ab", "!",
        "!@", "_"})
    void testCheckProgressStatusFail(String input) {
        assertThatThrownBy(() -> GameProgressStatus.checkRestartOrExit(input))
            .isInstanceOf(InvalidRestartOrExitInputException.class);
    }

    @Test
    @DisplayName("게임 재시작 또는 종료 입력 체크 성공")
    void testCheckProgressStatusSuccess() {
        assertTrue(GameProgressStatus.checkRestartOrExit("1"), "게임 재시작 체크 오류");
        assertFalse(GameProgressStatus.checkRestartOrExit("2"), "게임 종료 체크 오류");
    }
}
