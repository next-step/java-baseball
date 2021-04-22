package baseball.model;

import baseball.exception.BaseballNumberFormatException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballResultTest {
    @Test
    void test1() {
        BaseballNumber baseballNumber1 = BaseballNumber.builder().build();
        BaseballNumber baseballNumber2 = BaseballNumber.builder().build();

        BaseballResult result = BaseballResult.calcResult(baseballNumber1, baseballNumber2);
        System.out.println(result.description());
    }

    @Test
    void test2() {
        BaseballNumber baseballNumber1 = BaseballNumber.builder().build();

        BaseballResult result = BaseballResult.calcResult(baseballNumber1, baseballNumber1);
        System.out.println(result.description());
    }

    @Test
    void test3() {
        assertThatExceptionOfType(BaseballNumberFormatException.class).isThrownBy(() -> {
            BaseballNumber baseballNumber = new BaseballNumber("121");
            System.out.println(baseballNumber);
        });
    }
}
