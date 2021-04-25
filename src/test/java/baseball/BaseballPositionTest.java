package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballPositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void 위치값_0_이상의_값으로_객체_생성(int val) {
        BaseballPosition.create(val);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -6})
    void 위치값_0_미만의_값으로_객체_생성시_예외(int val) {
        assertThrows(IllegalArgumentException.class, () -> BaseballPosition.create(val));
    }

    @Test
    void 같은_숫자를_가진_객체가_SET에_존재하지_않는다() {
        final int EXPECTED_SIZE = 1;
        Set<BaseballPosition> baseballPositions = new HashSet<>();
        baseballPositions.add(BaseballPosition.create(1));
        baseballPositions.add(BaseballPosition.create(1));

        assertEquals(EXPECTED_SIZE, baseballPositions.size());
    }
}