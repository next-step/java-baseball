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
     * 214, 203 -> 1
     * 214, 816 -> 1
     * 214, 984 -> 1
     */
    @Test
    public void isCountedOneStrikeWhenFirstIsFixed(){
        String createdStr = "214";

        assertEquals(calculator.getStrikesCnt(createdStr, "203"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "816"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "984"), 1);
    }

    /* 스트라이크 2개 반환하기 (1 고정, 1 변합)
     * 2개의 스트라이크는 3개의 숫자라고 가정할 때 3곳에서 일어난다. 그것을 표현한 테스트 셋이다.
     * 214, 213 -> 2
     * 214, 814 -> 2
     * 214, 284 -> 2
     */
    @Test
    public void isCountedTwoStrikeWhenFirstIsFixed(){
        String createdStr = "214";

        assertEquals(calculator.getStrikesCnt(createdStr, "213"), 2);
        assertEquals(calculator.getStrikesCnt(createdStr, "814"), 2);
        assertEquals(calculator.getStrikesCnt(createdStr, "284"), 2);
    }

    /* 스트라이크 최종 테스트. 많은 상황에서 잘 동작하는지 확인
     * 214, 928 -> 0
     * 214, 203 -> 1
     * 214, 816 -> 1
     * 214, 984 -> 1
     * 214, 213 -> 2
     * 214, 814 -> 2
     * 214, 284 -> 2
     * 214, 214 -> 3
     */
    @Test
    public void isCountedStrikesManyWhenFirstIsFixed(){
        String createdStr = "214";

        assertEquals(calculator.getStrikesCnt(createdStr, "928"), 0);
        assertEquals(calculator.getStrikesCnt(createdStr, "203"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "816"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "984"), 1);
        assertEquals(calculator.getStrikesCnt(createdStr, "213"), 2);
        assertEquals(calculator.getStrikesCnt(createdStr, "814"), 2);
        assertEquals(calculator.getStrikesCnt(createdStr, "284"), 2);
        assertEquals(calculator.getStrikesCnt(createdStr, "214"), 3);
    }

    @Test
    public void isCountedBallsWhen123And456(){
        String testStr = "123";
        assertEquals(calculator.getBallsCnt(testStr, "456"), 0);
    }

    /* 볼 1개 반환하기 (1개 고정, 1개 변함)
     * 214, 456 -> 1
     * 214, 561 -> 1
     * 214, 732 -> 1
     */
    @Test
    public void isCountedOneBallWhenFirstIsFixed(){
        String createdStr = "214";

        assertEquals(calculator.getBallsCnt(createdStr, "456"), 1);
        assertEquals(calculator.getBallsCnt(createdStr, "561"), 1);
        assertEquals(calculator.getBallsCnt(createdStr, "732"), 1);
    }

    /* 볼 2개 반환하기 (1개 고정, 1개 변함)
     * 214, 143 -> 2
     * 214, 321 -> 2
     * 214, 432 -> 2
     */
    @Test
    public void isCountedTwoBallWhenFirstIsFixed(){
        String createdStr = "214";

        assertEquals(calculator.getBallsCnt(createdStr, "143"), 2);
        assertEquals(calculator.getBallsCnt(createdStr, "321"), 2);
        assertEquals(calculator.getBallsCnt(createdStr, "432"), 2);
    }

}
