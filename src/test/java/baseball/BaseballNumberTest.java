package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 입력되는_숫자가_1이상_9이하(int rangedNumber) {
        BaseballNumber.create(rangedNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10, 100, -5})
    void 입력되는_숫자가_1이상_9이하가_아니면_예외(int exceedRangeNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> BaseballNumber.create(exceedRangeNumber));
    }

    @Test
    void 같은_숫자를_가진_객체가_SET에_존재하지_않는다() {
        final int EXPECTED_SIZE = 1;
        Set<BaseballNumber> baseballNumbers = new HashSet<>();
        baseballNumbers.add(BaseballNumber.create(1));
        baseballNumbers.add(BaseballNumber.create(1));

        assertEquals(EXPECTED_SIZE, baseballNumbers.size());
    }
}