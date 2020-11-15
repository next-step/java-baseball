package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballUtilsTest {

    @Nested
    @DisplayName("사용자 입력 숫자 유효성 테스트")
    class IsValidInputTest {
        @ParameterizedTest
        @CsvSource(value = {"123:true", "999:true", "432:true", "4:false", "5321:false"}, delimiter = ':')
        @DisplayName("3자리인 경우만 true를 응답하는지 확인")
        void validInputLength3(String input, boolean result) {
            assertThat(BaseballUtils.isValidInput(input)).isEqualTo(result);
        }

        @ParameterizedTest
        @CsvSource(value = {"123:true", "999:true", "432:true", "402:false", "a12:false"}, delimiter = ':')
        @DisplayName("1-9 인 경우만 true를 응답하는지 확인")
        void validInputRangeOneToNine(String input, boolean result) {
            assertThat(BaseballUtils.isValidInput(input)).isEqualTo(result);
        }
    }
}
