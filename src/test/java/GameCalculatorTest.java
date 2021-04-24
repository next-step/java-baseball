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

    @Test
    public void isCalculatedStrikesAndBallsFinal() {
        Assertions.assertArrayEquals(gameCalculator.calculateResult("123","456"), new int[]{0,0});
        Assertions.assertArrayEquals(gameCalculator.calculateResult("231","123"), new int[]{0,3});
        Assertions.assertArrayEquals(gameCalculator.calculateResult("537","832"), new int[]{1,0});
        Assertions.assertArrayEquals(gameCalculator.calculateResult("713","712"), new int[]{2,0});
        Assertions.assertArrayEquals(gameCalculator.calculateResult("543","753"), new int[]{1,1});
    }
}
