package practice.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseballLogicTest {

    private BaseballLogic objLogic;

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

        int[][] input = {{1,2,3}, {1,1,2}, {1,4,4}, {6, 3 , 6}};
        assertThat((boolean) method.invoke( this.objLogic, input[0] )).isFalse();
        assertThat((boolean) method.invoke( this.objLogic, input[1] )).isTrue();
        assertThat((boolean) method.invoke( this.objLogic, input[2] )).isTrue();
        assertThat((boolean) method.invoke( this.objLogic, input[3] )).isTrue();
    }





}

