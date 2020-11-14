package baseball;


import org.junit.Assert;
import org.junit.Test;

public class BaseballGameStarterTest {

    private BaseballGameStarter baseballGameStarter = new BaseballGameStarter();

    @Test
    public void Test_makeComputerNumber() {
        for (int i = 0; i < 10; i++) {
            String computerNumber = baseballGameStarter.makeComputerNumber();
            Assert.assertEquals(3, computerNumber.length());

            int num1 = computerNumber.charAt(0);
            int num2 = computerNumber.charAt(1);
            int num3 = computerNumber.charAt(2);

            Assert.assertTrue(num1 != num2);
            Assert.assertTrue(num1 != num3);
            Assert.assertTrue(num2 != num3);
        }
    }
}