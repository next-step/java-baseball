package practice.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseballLogicTest {

    private BaseballLogic objLogic;

    public BaseballLogicTest() {
        this.objLogic = new BaseballLogic();
    }

    @Test
    void setBaseballNumbersTest() {
        int[] arrNumbers = this.objLogic.setBaseballNumbers();
        for( int elemNumbers : arrNumbers ) {
            assertThat(elemNumbers).isBetween(1, 9);
        }
    }

    @Test
    void checkValidNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = this.objLogic.getClass().getDeclaredMethod("checkValidNumber", int[].class);
        method.setAccessible(true);

        int[][] input = {{1,2,3}, {1,1,2}, {1,4,4}, {6,3,6}};
        assertThat((boolean) method.invoke( this.objLogic, input[0] )).isFalse();
        assertThat((boolean) method.invoke( this.objLogic, input[1] )).isTrue();
        assertThat((boolean) method.invoke( this.objLogic, input[2] )).isTrue();
        assertThat((boolean) method.invoke( this.objLogic, input[3] )).isTrue();
    }

    @Test
    void compareUserNumberWithNumberTest() {
        int[] arrBaseball = {1,2,3};
        int[][] input = {{1,2,3}, {1,4,2}, {6,2,4}, {6,3,1}, {1,3,2}};

        this.objLogic.setBaseballNumberUsingArray(arrBaseball);
        assertThat(this.objLogic.compareUserNumberWithNumber(input[0])).isEqualTo(3);
        assertThat(this.objLogic.compareUserNumberWithNumber(input[1])).isEqualTo(2);
        assertThat(this.objLogic.compareUserNumberWithNumber(input[2])).isEqualTo(1);
        assertThat(this.objLogic.compareUserNumberWithNumber(input[3])).isEqualTo(2);
        assertThat(this.objLogic.compareUserNumberWithNumber(input[4])).isEqualTo(3);
    }

    @Test
    void isStrikeTest()  throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] arrBaseball = {1,2,3};
        this.objLogic.setBaseballNumberUsingArray(arrBaseball);
        Method method = this.objLogic.getClass().getDeclaredMethod("isStrike", int.class, int.class);
        method.setAccessible(true);

        int[][] iTestInput = {{1,0}, {1,1}, {3,2}, {7,0}};
        assertThat((int) method.invoke( this.objLogic, iTestInput[0][0], iTestInput[0][1] ) ).isEqualTo(1);
        assertThat((int) method.invoke( this.objLogic, iTestInput[1][0], iTestInput[1][1] ) ).isEqualTo(0);
        assertThat((int) method.invoke( this.objLogic, iTestInput[2][0], iTestInput[2][1] ) ).isEqualTo(1);
        assertThat((int) method.invoke( this.objLogic, iTestInput[3][0], iTestInput[3][1] ) ).isEqualTo(0);
    }

    @Test
    void isBallTest()  throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] arrBaseball = {1,2,3};
        this.objLogic.setBaseballNumberUsingArray(arrBaseball);
        Method method = this.objLogic.getClass().getDeclaredMethod("isBall", int.class);
        method.setAccessible(true);

        int[] iTestInput = {1, 3, 4, 7};
        assertThat((int) method.invoke( this.objLogic, iTestInput[0]) ).isEqualTo(1);
        assertThat((int) method.invoke( this.objLogic, iTestInput[1]) ).isEqualTo(1);
        assertThat((int) method.invoke( this.objLogic, iTestInput[2]) ).isEqualTo(0);
        assertThat((int) method.invoke( this.objLogic, iTestInput[3]) ).isEqualTo(0);
    }


}

