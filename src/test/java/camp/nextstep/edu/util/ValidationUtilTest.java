package camp.nextstep.edu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "12", "123"})
    @DisplayName("숫자 문자열 유효성 검사 - 성공 테스트")
    void isNumber_successTest(String str) {
        // given & when
        boolean result = ValidationUtil.isNumber(str);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "a1", "abc", "가", "가1", "가나다", "a가1"})
    @DisplayName("숫자 문자열 유효성 검사 - 실패 테스트")
    void isNumber_failureTest(String str) {
        // given & when
        boolean result = ValidationUtil.isNumber(str);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "가나다", "123", "ab가", "가나1", "a가1"})
    @DisplayName("문자열 중복 유효성 검사 - 성공 테스트")
    void isDistinct_successTest(String str) {
        // given & when
        boolean result = ValidationUtil.isDistinct(str);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aab", "가가나", "112", "aa가", "가가1", "a11"})
    @DisplayName("문자열 중복 유효성 검사 - 실패 테스트")
    void isDistinct_failureTest(String str) {
        // given & when
        boolean result = ValidationUtil.isDistinct(str);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"abc:d", "가나다:라", "123:4"}, delimiter = ':')
    @DisplayName("미포함 유효성 검사 - 성공 테스트")
    void isNotContains_successTest(String str, String except) {
        // given & when
        boolean result = ValidationUtil.isNotContains(str, except);

        // then
        assertThat(result).isTrue();
    }
}
