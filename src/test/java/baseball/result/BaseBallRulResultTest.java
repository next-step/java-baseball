package baseball.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallRulResultTest {

    @DisplayName("3 스트라이크 게임 종료")
    @Test
    void output() {
        BaseBallResult result = BaseBallRulResult.rulResult(3, 0);
        assertEquals("3 스트라이크 ", result.getPrintResult());
        assertTrue(result.isPlay());
    }

    @DisplayName("2 스트라이크 1 게임 종료 아님")
    @Test
    void not_end_Routput() {
        BaseBallResult result = BaseBallRulResult.rulResult(2, 1);
        assertEquals("2 스트라이크 1볼", result.getPrintResult());
        assertFalse(result.isPlay());
    }

}