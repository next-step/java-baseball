package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Numbers를 테스트한다")
class NumbersTest {

    @DisplayName("3개의 숫자가 위치까지 똑같다면 equals의 결과는 true이다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "914", "853", "593", "583"})
    void equals(final String value) {
        final Numbers numbers1 = Numbers.valueOf(value);
        final Numbers numbers2 = Numbers.valueOf(value);
        assertThat(numbers1).isEqualTo(numbers2);
    }

    @DisplayName("3자리의 숫자가 아니라면 IllegalArgumentException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "3914", "8273", "1827"})
    void sizeTest(final String value) {
        assertThatThrownBy(() -> {
            Numbers.valueOf(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLEASE_INPUT_VALID_NUMBERS);
    }

    @DisplayName("중복된 숫자가 있다면 IllegalArgumentException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"112", "133", "5122", "5123"})
    void duplicateTest() {
        assertThatThrownBy(() -> {
            Numbers.valueOf(new ArrayList(Arrays.asList("1", "1", "3")));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLEASE_INPUT_VALID_NUMBERS);
    }

}
