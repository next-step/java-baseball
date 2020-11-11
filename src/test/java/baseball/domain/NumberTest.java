package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.Number.MAX_NUMBER;
import static baseball.domain.Number.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {
    @ParameterizedTest
    @DisplayName("Number 는 1 ~ 9 사이의 숫자이다.")
    @ValueSource(ints = {1, 5, 9})
    void create(int number) {
        assertThat(new Number(number)).isEqualTo(new Number(number));
    }

    @ParameterizedTest
    @DisplayName("Number 는 1 ~ 9 이 아닐 경우 예외 발생")
    @ValueSource(ints = {MIN_NUMBER - 1, 0, MAX_NUMBER + 1})
    void createException(int number) {
        assertThrows(IllegalArgumentException.class, () -> new Number(number));
    }
}
