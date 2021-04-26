import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

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

    @Test
    public void isValidatedDigit() {
        for (int i=0; i<InputBall.length(); i++)
            Assertions.assertTrue(Pattern.matches("^[1-9]", InputBall.charAt(i) + ""));

    }
}
