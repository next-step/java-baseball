import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class BaseballGameResultCalculatorTest {
    private BaseballGameResultCalculator calculator;

    @Before
    public void setUp(){
        calculator = new BaseballGameResultCalculator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isCounted3StrikesWhen123And123(){
        String testStr = "123";
        assertEquals(calculator.getStrikesCnt(testStr, testStr), 3);
    }

}
