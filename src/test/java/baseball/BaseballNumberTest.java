package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 입력되는_숫자가_1이상_9이하(int rangedNumber) {
        BaseballNumber.createByNumberAndPosition(rangedNumber, 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10, 100, -5})
    void 입력되는_숫자가_1이상_9이하가_아니면_예외(int exceedRangeNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> BaseballNumber.createByNumberAndPosition(exceedRangeNumber, 0));
    }
}