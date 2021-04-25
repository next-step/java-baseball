package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 입력되는_숫자가_1이상_9이하(int rangedNumber) {
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballNumber.addNumber(rangedNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10, 100, -5})
    void 입력되는_숫자가_1이상_9이하가_아니면_예외(int exceedRangeNumber) {
        BaseballNumber baseballNumber = new BaseballNumber();
        assertThrows(IllegalArgumentException.class,
                () -> baseballNumber.addNumber(exceedRangeNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3",
            "4, 5, 6",
            "7, 8, 9",
            "1, 5, 9",
            "4, 9, 1"
    })
    void 중복되지_않는_숫자는_모두_생성된다(int a, int b, int c) {
        //given
        final int EXPECTED_SIZE = 3;
        BaseballNumber baseballNumber = new BaseballNumber();

        //when
        baseballNumber.addNumber(a);
        baseballNumber.addNumber(b);
        baseballNumber.addNumber(c);

        //then
        assertEquals(EXPECTED_SIZE, baseballNumber.size());
    }

    @Test
    void 중복된_숫자는_생성되지_않는다() {
        //given
        final int EXPECTED_SIZE = 1;
        int rangedNumber = 5;
        BaseballNumber baseballNumber = new BaseballNumber();

        //when
        baseballNumber.addNumber(rangedNumber);
        baseballNumber.addNumber(rangedNumber);
        baseballNumber.addNumber(rangedNumber);

        //then
        assertEquals(EXPECTED_SIZE, baseballNumber.size());
    }
}