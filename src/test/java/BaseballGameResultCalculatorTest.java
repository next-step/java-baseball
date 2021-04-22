import org.junit.Before;

public class BaseballGameResultCalculatorTest {
    private BaseballGameResultCalculator calculator;

    @Before
    public void setUp(){
        calculator = new BaseballGameResultCalculator(BaseballGame.DEFAULT_LEN);
    }

}
