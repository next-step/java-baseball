import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameCalculatorTest {
    private GameCalculator gameCalculator;

    @BeforeEach
    public void beforeSet() {
        gameCalculator = new GameCalculator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isCalculated3StrikeAnd0Ball() {
        Assertions.assertArrayEquals(gameCalculator.calculateResult("123","123"), new int[]{3,0});
    }
}
