package baseball.output;

import baseball.game.BaseBallResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallOutputerTest {

    @DisplayName("3 스트라이크 게임 종료")
    @Test
    void output() {
        BaseBallResult result = BaseBallOutputer.output(3, 0);
        assertEquals("3 스트라이크 ", result.getPrintResult());
        assertTrue(result.isEnd());
    }

    @DisplayName("2 스트라이크 1 게임 종료 아님")
    @Test
    void not_end_Routput() {
        BaseBallResult result = BaseBallOutputer.output(2, 1);
        assertEquals("2 스트라이크 1볼", result.getPrintResult());
        assertFalse(result.isEnd());
    }

}