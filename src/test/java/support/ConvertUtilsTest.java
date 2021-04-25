package support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertUtilsTest {
    private static final int INT_VALUE = 123;
    private static final int[] ARRAY_VALUE = {1, 2, 3};

    @DisplayName("Int should be converted to array")
    @Test
    void testConvertIntToArray() {
        assertThat(ConvertUtils.convertIntToArray(INT_VALUE)).isEqualTo(ARRAY_VALUE);
    }

    @DisplayName("Array should be converted to int")
    @Test
    void testConvertArrayToInt() {
        assertThat(ConvertUtils.convertArrayToInt(ARRAY_VALUE)).isEqualTo(INT_VALUE);
    }
}
