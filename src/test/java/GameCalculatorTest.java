import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameCalculatorTest {
    private GameCalculator gameCalculator;

    @Test
    public void beforeSet() {
        gameCalculator = new GameCalculator(BaseballGame.DEFAULT_LEN);
    }
}
