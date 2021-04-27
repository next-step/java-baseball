import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    private BaseballGame baseballgame;

    @BeforeEach
    public void beforeSet() {
        baseballgame = new BaseballGame(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isValidatedLength1() {
        Assertions.assertEquals(baseballgame.endInputRead("1"),"1");
        Assertions.assertEquals(baseballgame.endInputRead("10"),"FALSE");
    }

    @Test
    public void isValidatedDigit1To2() {
        Assertions.assertEquals(baseballgame.endInputRead("2"),"2");
        Assertions.assertEquals(baseballgame.endInputRead("3"),"FALSE");
    }
}
