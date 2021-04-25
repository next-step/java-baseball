package baseball.domain;

import baseball.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Number를 테스트한다")
class NumberTest {

    @DisplayName("0으로 생성할 수 없다")
    @Test
    void createZero() {
        final int value = 0;
        assertThrows(NumberOutOfRangeException.class, () -> Number.valueOf(value));
    }

    @DisplayName("음수로 생성할 수 없다")
    @Test
    void createLess() {
        final int value = - 1;
        assertThrows(NumberOutOfRangeException.class, () -> Number.valueOf(value));
    }

    @DisplayName(Number.MIN_VALUE + " ~ " + Number.MAX_VALUE + " 사이의 숫자로 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {Number.MIN_VALUE, 2, 3, 4, 5, 6, 7, 8, Number.MAX_VALUE})
    void create(final int value) {
        final Number number = Number.valueOf(value);
        assertThat(number).isNotNull();
    }

    @DisplayName(Number.MAX_VALUE + "를 초과하는 수로 생성할 수 없다")
    @Test
    void createMore() {
        final int value = 10;
        assertThrows(NumberOutOfRangeException.class, () -> Number.valueOf(value));
    }

    @DisplayName("캐싱을 통해 같은 객체를 보장한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    void deepEquals(final int value) {
        final Number number1 = Number.valueOf(value);
        final Number number2 = Number.valueOf(value);
        assertAll(
                () -> assertThat(number1).isEqualTo(number2),
                () -> assertThat(number1 == number2).isTrue()
        );
    }
}
