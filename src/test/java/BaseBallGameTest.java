import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseBallGameTest {

    BaseBallGame baseBallGame=new BaseBallGame();

    @DisplayName("볼 카운트가 제대로 반환되는지 확인")
    @Test
    void getBallCountTest(){

        assertEquals(new BallCount(3,0).toString(),
                baseBallGame.getBallCount("123","123").toString());
        assertEquals(new BallCount(1,2).toString(),
                baseBallGame.getBallCount("321","123").toString());
        assertEquals(new BallCount(0,0).toString(),
                baseBallGame.getBallCount("123","456").toString());
        assertEquals(new BallCount(1,1).toString(),
                baseBallGame.getBallCount("283","389").toString());
        assertEquals(new BallCount(0,3).toString(),
                baseBallGame.getBallCount("456","564").toString());
        assertEquals(new BallCount(1,2).toString(),
                baseBallGame.getBallCount("456","654").toString());

    }

    @DisplayName("유저 입력이 규칙에 맞는지 확인")
    @Test
    void validateUserAnswer(){

        assertTrue(baseBallGame.validateUserAnswer("123"));
        assertTrue(baseBallGame.validateUserAnswer("281"));
        assertTrue(baseBallGame.validateUserAnswer("391"));
        assertTrue(baseBallGame.validateUserAnswer("452"));
        assertTrue(baseBallGame.validateUserAnswer("456"));
        assertTrue(baseBallGame.validateUserAnswer("172"));
        assertTrue(baseBallGame.validateUserAnswer("124"));
        assertTrue(baseBallGame.validateUserAnswer("523"));
        assertTrue(baseBallGame.validateUserAnswer("921"));
        assertFalse(baseBallGame.validateUserAnswer("122"));
        assertFalse(baseBallGame.validateUserAnswer("1114"));
        assertFalse(baseBallGame.validateUserAnswer("2"));
        assertFalse(baseBallGame.validateUserAnswer("525"));
        assertFalse(baseBallGame.validateUserAnswer("1000"));
        assertFalse(baseBallGame.validateUserAnswer("-12"));
        assertFalse(baseBallGame.validateUserAnswer("444"));
        assertFalse(baseBallGame.validateUserAnswer("012"));

    }

    @DisplayName("시작 입력 규칙에 맞는지 확인")
    @Test
    void validateStartInputTest(){

        assertTrue(baseBallGame.validateStartInput("1"));
        assertTrue(baseBallGame.validateStartInput("2"));
        assertFalse(baseBallGame.validateStartInput("-1"));
        assertFalse(baseBallGame.validateStartInput("12421"));
        assertFalse(baseBallGame.validateStartInput("-2"));
    }
}
