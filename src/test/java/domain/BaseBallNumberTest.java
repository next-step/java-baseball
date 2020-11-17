package domain;

import exception.BaseBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumberTest {

    @DisplayName("입력한 숫자가 1~9까지 범위를 벗어나는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    void validate_number_range_test(int input) {
        assertThatThrownBy(() -> {
            new BaseBallNumber(input);
        }).isInstanceOf(BaseBallException.class)
                .hasMessage("각 자리 숫자는 1~9까지로 이루어져야 합니다.");
    }

}
