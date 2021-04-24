import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    private BaseballGame Baseballgame;

    @Test
    public void beforeSet() {
        Baseballgame = new BaseballGame(BaseballGame.DEFAULT_LEN);
    }
}
