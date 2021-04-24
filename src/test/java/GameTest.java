import org.junit.jupiter.api.Test;

public class GameTest {
    private BaseballGame Baseballgame;

    @Test
    public void beforeSet() {
        Baseballgame = new BaseballGame(3);
    }
}
