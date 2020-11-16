package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameDigitTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 11, 12, 100, 999999})
    @DisplayName("생성 시 한 자리의 숫자가 아니면 예외를 발생시킨다.")
    void oneDigitTest(int input) {
        assertThatThrownBy(() -> new GameDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}