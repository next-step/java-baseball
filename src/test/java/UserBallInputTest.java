import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserBallInputTest {
    private UserBallInput userBallInput;
    private String InputBall;

    @BeforeEach
    public void setUp() {
        userBallInput = new UserBallInput(BaseballGame.DEFAULT_LEN);
        InputBall = userBallInput.UserBallInputRead();
    }

    @Test
    public void isValidatedLength() {
        Assertions.assertEquals(InputBall.length(), BaseballGame.DEFAULT_LEN);
    }
}
