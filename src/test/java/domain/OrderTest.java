package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @DisplayName("자릿수 index 값이 0~2 범위를 넘어갈 경우, Exception 발생.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void validateRangePosition(int value) {
        assertThatThrownBy(() -> new Order(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자릿수 범위를 초과하였습니다.");
    }

}
