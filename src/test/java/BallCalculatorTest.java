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

    private void assertBallsWhenFirstIsFixed(String generated, String[] inputs, int ballsCnt) {
        for (String input : inputs)
            Assertions.assertEquals(ballCalculator.getBallsCnt(generated, input), ballsCnt);
    }

    @Test
    public void isCountedOneBallWhenFirstIsFixed(){
        String[] inputs = {"472", "639", "516"};
        int index = 1;
        assertBallsWhenFirstIsFixed("123", inputs, index);
    }

    @Test
    public void isCountedTwoBallsWhenFirstIsFixed(){
        String [] inputs = {"372","631", "216"};
        int index = 2;
        assertBallsWhenFirstIsFixed("123", inputs, index);
    }

    @Test
    public void isCountedThreeBallsWhenFirstIsFixed(){
        String [] inputs = { "231", "312" };
        int index = 3;
        assertBallsWhenFirstIsFixed("123", inputs, index);
    }

    @Test
    public void isCountedBallsFinal(){
        Assertions.assertEquals(ballCalculator.getBallsCnt("723", "945"), 0);
        Assertions.assertEquals(ballCalculator.getBallsCnt("631", "962"), 1);
        Assertions.assertEquals(ballCalculator.getBallsCnt("163", "618"), 2);
        Assertions.assertEquals(ballCalculator.getBallsCnt("672", "726"), 3);
    }
}
