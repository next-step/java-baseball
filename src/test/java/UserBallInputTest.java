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

    private int getStrNumber(String str, char c) {
        int cnt = 0;

        for(int i=0;i<str.length();i++)
            cnt += str.charAt(i) == c ? 1 : 0;

        return cnt;
    }

    @Test
    public void isValidatedUnique() {

        for(int i=0;i<InputBall.length();i++)
            Assertions.assertEquals(getStrNumber(InputBall, InputBall.charAt(i)), 1);

    }
}
