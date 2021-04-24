import org.junit.jupiter.api.Test;

public class StrikeCalculatorTest {

    private StrikeCalculator strikeCalculator;

    @Test
    public void beforeSet() {
        strikeCalculator = new StrikeCalculator(BaseballGame.DEFAULT_LEN);
    }
}
