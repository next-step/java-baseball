package game.baseball.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import game.baseball.number.exceptions.InvalidUserInputTypingException;
import game.baseball.number.status.GameProgressStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameProgressStatusTest {

    @ParameterizedTest
    @DisplayName("게임 재시작 또는 종료 입력 체크 실패")
    @ValueSource(strings = {"", " ", "1 ", "2 ", " 1", " 2", " 1 ", " 2 ", "3", "4", "11", "111", "a", "ab", "!",
        "!@", "_"})
    public void checkProgressStatusFail(String input) {
        assertThatThrownBy(() -> GameProgressStatus.checkProgressStatus(input))
            .isInstanceOf(InvalidUserInputTypingException.class);
    }

    @Test
    @DisplayName("게임 재시작 또는 종료 입력 체크 성공")
    public void checkProgressStatusSuccess() {
        assertTrue(GameProgressStatus.checkProgressStatus("1"));
        assertFalse(GameProgressStatus.checkProgressStatus("2"));
    }
}