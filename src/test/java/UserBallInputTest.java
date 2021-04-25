import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserBallInputTest {
    private UserBallInput userBallInput;

    @Test
    public void setUp() {
        userBallInput = new UserBallInput(BaseballGame.DEFAULT_LEN);
    }
}
