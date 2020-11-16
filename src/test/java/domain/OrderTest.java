package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order(1);
    }

    @DisplayName("자릿수 index 값이 0~2 범위를 넘어갈 경우, Exception 발생.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void validateRangePosition(int value) {
        assertThatThrownBy(() -> new Order(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자릿수 범위를 초과하였습니다.");
    }

    @DisplayName("입력받은 다른 자릿수 index 값이 일치할 경우, true 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"1:true"}, delimiter = ':')
    void isEqual_TRUE(int index, boolean expected) {
        boolean result = order.isEqual(new Order(index));
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력받은 다른 자릿수 index 값이 다를 경우, false 리턴.")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "2:false"}, delimiter = ':')
    void isEqual_FALSE(int index, boolean expected) {
        boolean result = order.isEqual(new Order(index));
        assertThat(result).isEqualTo(expected);
    }
}
