import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallCalculatorTest {

    private BallCalculator ballCalculator;

    @BeforeEach
    public void beforeSet() {
        ballCalculator = new BallCalculator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isCountedBallsWhen123And456() {
        Assertions.assertEquals(ballCalculator.getBallsCnt("123","456"),0);
    }
}
