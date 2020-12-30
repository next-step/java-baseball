package practice.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class BaseballLogicTest {

    private BaseballLogic objLogic;

    public BaseballLogicTest() {
        this.objLogic = new BaseballLogic();
    }

    @Test
    void setBaseballNumbers() {
        int[] arrNumbers = this.objLogic.setBaseballNumbers();
        for( int elemNumbers : arrNumbers ) {
            assertThat(elemNumbers).isBetween(1, 9);
        }
    }

}

