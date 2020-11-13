package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 1000, 10000})
    @DisplayName("3자리를 가지지 않으면 예외를 발생시킨다.")
    void hasThreeNumberTest(int number) {
        assertThatThrownBy(() -> UserNumber.validateThreeLength(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {1, 10, 1000, 10000})
    @DisplayName("각 자리 수에 같은 숫자가 있으면 예외를 발생시킨다.")
    void duplicateNumberExistTest(int number) {
        assertThatThrownBy(() -> UserNumber.validateDuplication(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}