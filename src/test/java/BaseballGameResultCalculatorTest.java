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

    /* 스트라이크 1개 반환하기 (1 고정, 1 변합)
     * 1개의 스트라이크는 3개의 숫자라고 가정할 때 3곳에서 일어난다. 그것을 표현한 테스트 셋이다.
     * 214, 201 -> 1
     * 214, 816 -> 1
     * 214, 984 -> 1
     */
    @Test
    public void isCountedOneStrikeWhenFirstIsFixed(){
        String createdStr = "214";

        assertEquals(calculator.getStrikesCnt(createdStr, "201"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "816"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "984"), 1);
    }

}
