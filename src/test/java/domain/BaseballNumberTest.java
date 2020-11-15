package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    @DisplayName("숫자 길이를 만족하지 못할 경우")
    @ParameterizedTest
    @ValueSource(ints = {12, 1234, 9})
    void validateLength(int number) {
        assertThatThrownBy(() -> new BaseballNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 3개만 입력해주세요.");
    }

    @DisplayName("0이 들어가 있을 경우")
    @ParameterizedTest
    @ValueSource(ints = {102, 130})
    void validateZero(int number) {
        assertThatThrownBy(() -> new BaseballNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이 들어있습니다.");
    }

    @DisplayName("중복된 숫자가 있을 경우")
    @ParameterizedTest
    @ValueSource(ints = {111, 121, 889})
    void validateDuplicate(int number) {
        assertThatThrownBy(() -> new BaseballNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 숫자 3개만 입력해주세요.");
    }
}
