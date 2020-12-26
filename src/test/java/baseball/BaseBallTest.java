package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseBallTest {
    BaseBall unitTest = new BaseBall();

    @Test
    public void setNumTest(){
        int num, num1, num2, num3;
        num = unitTest.setNumTest();
        num3 = num%10; num /= 10;
        num2 = num%10; num /= 10;
        num1 = num%10; num /= 10;

        assertThat(num1).isNotEqualTo(num2).isNotEqualTo(num3);
        assertThat(num2).isNotEqualTo(num3);
    }


}
