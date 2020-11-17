package edu.example.numberbaseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collection 관련 Utility 기능에 대한 테스트")
class CollectionUtilTest {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int TEN = 10;
    private static final int INTEGER_FOR_TEST = 100;

    @DisplayName("입력한 start부터 end까지 번호로 구성된 Collection이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {ONE, TWO, TEN})
    void fillRange(int input) {
        List<Integer> integerList = CollectionUtil.fillRange(input, INTEGER_FOR_TEST);

        int autualListSize = integerList.size();
        int expectedListSize = INTEGER_FOR_TEST - input + ONE;

        assertEquals(expectedListSize, autualListSize);
    }

    @DisplayName("입력한 start는 end보다 작거나 같지 않으면 예외가 발생한다. 조건: `start <= end`")
    @ParameterizedTest
    @ValueSource(ints = {ONE, TWO, TEN})
    void fillRangeWithInvalidParameter(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CollectionUtil.fillRange(INTEGER_FOR_TEST, input));
    }
}
