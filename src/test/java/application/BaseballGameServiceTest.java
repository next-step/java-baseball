package application;

import domain.BaseballCountVo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameServiceTest {

    BaseballGameService baseballGameService = new BaseballGameService();

    @Test
    void isResult() {

        BaseballCountVo testResult1 = baseballGameService.isResult("345", "356");
        assertEquals(testResult1.getStrike() , 1);
        assertEquals(testResult1.getBall(),1);

        BaseballCountVo testResult2 = baseballGameService.isResult("456", "789");
        assertEquals(testResult2.getStrike() , 0);
        assertEquals(testResult2.getBall(),0);

        BaseballCountVo testResult3 = baseballGameService.isResult("194", "941");
        assertEquals(testResult3.getStrike() , 0);
        assertEquals(testResult3.getBall(),3);
    }

    @Test
    void getBaseballCount() {
        BaseballCountVo ballCountOneResult1 = baseballGameService.getBaseballCount(-1, 0);
        assertEquals(ballCountOneResult1.getStrike() , 0);
        assertEquals(ballCountOneResult1.getBall(),0);

        BaseballCountVo ballCountOneResult2 = baseballGameService.getBaseballCount(2, 1);
        assertEquals(ballCountOneResult2.getStrike() , 0);
        assertEquals(ballCountOneResult2.getBall(),1);

        BaseballCountVo ballCountOneResult3 = baseballGameService.getBaseballCount(1, 1);
        assertEquals(ballCountOneResult3.getStrike() , 1);
        assertEquals(ballCountOneResult3.getBall(),0);
    }

    @Test
    void stringToStringArray() {

        String[] emptyArray = baseballGameService.stringToStringArray("12345");
        assertEquals(emptyArray.length , 0);

        String[] numberArray = baseballGameService.stringToStringArray("485");
        assertEquals(numberArray[0], "4");
        assertEquals(numberArray[1], "8");
        assertEquals(numberArray[2], "5");

        String[] numberArray2 = baseballGameService.stringToStringArray("962");
        assertEquals(numberArray2[0], "9");
        assertEquals(numberArray2[1], "6");
        assertEquals(numberArray2[2], "2");
    }
}