package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseBallTest {
    BaseBall unitTest = new BaseBall();

    @Test
    void setNumTest(){
        int num, num1, num2, num3;
        num = unitTest.setNumTest();
        num3 = num%10; num /= 10;
        num2 = num%10; num /= 10;
        num1 = num%10; num /= 10;

        assertThat(num1).isNotEqualTo(num2).isNotEqualTo(num3);
        assertThat(num2).isNotEqualTo(num3);
    }

    @ParameterizedTest
    @CsvSource({"1,1,true", "1,5,false", "2,8,false", "5,5,true"})
    void checkStrikeTest(int user, int com, boolean expected){
        assertThat((unitTest.checkStrike(user, com) == 1)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,1,2,true", "1,3,8,false", "4,7,5,false", "9,4,9,true"})
    void checkBallTest(int user, int com1, int com2, boolean expected){
        assertThat((unitTest.checkBall(user, com1, com2) == 1)).isEqualTo(expected);
    }


}
