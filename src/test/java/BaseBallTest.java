import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    private BaseBall baseball;
    private Result result;

    @BeforeEach
    void prepare() {
        baseball = new BaseBall();
        result = new Result();
        result.setBalls(2);
        result.setStrikes(1);
        baseball.answer = new int[]{3, 4, 5};
    }

    @Test
    void init_generateAnswerArray() {
        baseball.init();
        assertNotNull(baseball.answer);
        assertEquals(baseball.answer.length, 3);
        assertNotEquals(baseball.answer[0], baseball.answer[1]);
        assertNotEquals(baseball.answer[1], baseball.answer[2]);
        assertTrue(baseball.answer[0] >= 1 && baseball.answer[0] <= 9);
        assertTrue(baseball.answer[1] >= 1 && baseball.answer[1] <= 9);
        assertTrue(baseball.answer[2] >= 1 && baseball.answer[2] <= 9);
    }

    @Test
    void isContain_shouldReturnTrueForParameterNumberExist() {
        assertTrue(baseball.isContain(3));
        assertTrue(baseball.isContain(4));
        assertTrue(baseball.isContain(5));
        assertFalse(baseball.isContain(6));
    }

    @Test
    void isStrike_shouldReturnCountForNumberInRightPosition() {
        assertTrue(baseball.isStrike(0, 3));
        assertTrue(baseball.isStrike(1, 4));
        assertTrue(baseball.isStrike(2, 5));
        assertFalse(baseball.isStrike(0, 1));
        assertFalse(baseball.isStrike(0, 5));
    }

    @Test
    void isBall_shouldReturnCountForNumberInAnswerNotStrike() {
        assertFalse(baseball.isBall(0, 3));
        assertFalse(baseball.isBall(1, 4));
        assertFalse(baseball.isBall(2, 5));
        assertFalse(baseball.isBall(0, 1));
        assertTrue(baseball.isBall(0, 5));
    }

    @Test
    void isInputValid_shouldCheckInvalidInput() {
        assertFalse(baseball.isInputValid("abc"));
        assertFalse(baseball.isInputValid("012"));
        assertFalse(baseball.isInputValid("1234"));
        assertTrue(baseball.isInputValid("426"));
    }
}