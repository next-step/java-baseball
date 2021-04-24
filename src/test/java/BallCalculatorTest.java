import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallCalculatorTest {

    private BallCalculator ballCalculator;

    @BeforeEach
    public void beforeSet() {
        ballCalculator = new BallCalculator(BaseballGame.DEFAULT_LEN);
    }
}
