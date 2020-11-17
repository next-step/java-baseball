package baseballgame.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("입력값이 문자열일 때 Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "a123", "!@#$%^&*()_+123"})
    void throw_exception_when_not_number(String input) {
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 0이 포함되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"123:false", "012:true", "450:true"}, delimiter = ':')
    void check_if_contains_zero(String input, boolean expected) {
        //when
        boolean result = input.indexOf("0") > -1;

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("3자리 수가 맞는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"123:true", "1234:false", "1:false"}, delimiter = ':')
    void check_if_validSize(String input, boolean expected) {
        //when
        boolean result = input.length() == 3;

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력값이 서로 다른 숫자인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"123:true", "111:false", "112:false"}, delimiter = ':')
    void check_if_isDifferentFromEachOther(String input, boolean expected) {
        //when
        HashSet<String> diffChecker = new HashSet<String>(Arrays.asList(input.split("")));
        boolean result = diffChecker.size() == 3;

        //then
        assertThat(result).isEqualTo(expected);
    }

}