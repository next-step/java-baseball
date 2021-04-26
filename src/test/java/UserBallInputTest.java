import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserBallInputTest {
    private UserBallInput userBallInput;
    private String InputBall;

    @BeforeEach
    public void setUp() {
        userBallInput = new UserBallInput(BaseballGame.DEFAULT_LEN);
        InputBall = userBallInput.userBallInputRead("123");
    }

    @Test
    public void isValidatedLength3() {
        Assertions.assertEquals(userBallInput.userBallInputRead("123"),"123");
        Assertions.assertEquals(userBallInput.userBallInputRead("1234"),"FALSE");
    }

    @Test
    public void isValidatedDigit1To9() {
        Assertions.assertEquals(userBallInput.userBallInputRead("456"),"456");
        Assertions.assertEquals(userBallInput.userBallInputRead("1A4"),"FALSE");
    }

    @Test
    public void isValidatedUnique() {
        Assertions.assertEquals(userBallInput.userBallInputRead("456"),"456");
        Assertions.assertEquals(userBallInput.userBallInputRead("114"),"FALSE");
    }
}
