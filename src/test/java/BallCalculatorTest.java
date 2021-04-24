import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallCalculatorTest {

    private BallCalculator ballCalculator;
    private String test123;

    @BeforeEach
    public void beforeSet() {
        ballCalculator = new BallCalculator(BaseballGame.DEFAULT_LEN);
        test123 = "123";
    }

    @Test
    public void isCountedBallsWhen123And456() {
        Assertions.assertEquals(ballCalculator.getBallsCnt(test123,"456"),0);
    }

    @Test
    public void isCounted1Ball() {
        Assertions.assertEquals(ballCalculator.getBallsCnt(test123,"472"),1);
        Assertions.assertEquals(ballCalculator.getBallsCnt(test123,"639"),1);
        Assertions.assertEquals(ballCalculator.getBallsCnt(test123,"516"),1);
    }
}
