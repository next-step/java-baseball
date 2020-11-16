package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("숫자가 1~9가 아닐 경우, Exception 발생")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void validateRangeNumber(Order order, int baseballNumber) {
        assertThatThrownBy(() -> new BaseballNumber(order, baseballNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 범위를 초과하였습니다.");
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(new Order(0), 0),
                Arguments.of(new Order(1), 10)
        );
    }
}