package baseball.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameStatusTest {
    @DisplayName("GameStatus PLAY 비교 - 성공")
    @Test
    public void gameStatus_is_play_equals_success() throws Exception {
        GameStatus status = GameStatus.PLAY;

        Assertions.assertTrue("1".equals(status.getCode()));
    }

    @DisplayName("GameStatus PLAY 비교 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "2", "3"})
    public void gameStatus_is_play_equals_fail(String input) throws Exception {
        GameStatus status = GameStatus.PLAY;

        Assertions.assertFalse(input.equals(status.getCode()));
    }
}
