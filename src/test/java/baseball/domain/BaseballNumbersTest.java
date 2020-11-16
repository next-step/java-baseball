package baseball.domain;

import baseball.exception.BizException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("입력한 야구게임 숫자 테스트")
public class BaseballNumbersTest {

    @DisplayName("입력한 숫자 유효성 검증 > 성공")
    @Test
    public void checkValidationSuccess() {
        BaseballNumbers baseballNumbers = new BaseballNumbers("243");
        baseballNumbers.checkValidation();
    }

    @DisplayName("입력한 숫자 유효성 검증 > 실패 : 숫자를 입력하지않음")
    @ParameterizedTest
    @ValueSource(strings = {".42", "b53", "6숫자"})
    public void checkValidationFailNotNumber(String numbers) {

        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        Throwable exception = assertThrows(BizException.class, () -> {
            baseballNumbers.checkValidation();
        });
        assertEquals("NUMBER_ONLY", exception.getMessage());
    }

    @DisplayName("입력한 숫자 유효성 검증 > 실패 : 입력 자리수 문제")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "4215"})
    public void checkValidationFailLength(String numbers) {

        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        Throwable exception = assertThrows(BizException.class, () -> {
            baseballNumbers.checkValidation();
        });
        assertEquals("INVALID_LENGTH", exception.getMessage());
    }

    @DisplayName("입력한 숫자 유효성 검증 > 실패 : 입력 가능한 숫자 범위가 아님")
    @ParameterizedTest
    @ValueSource(strings = {"041", "910", "207"})
    public void checkValidationFailBounds(String numbers) {

        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        Throwable exception = assertThrows(BizException.class, () -> {
            baseballNumbers.checkValidation();
        });
        assertEquals("OUT_OF_BOUNDS_NUMBER", exception.getMessage());
    }

    @DisplayName("입력한 숫자 유효성 검증 > 실패 : 중복된 값이 존재함")
    @ParameterizedTest
    @ValueSource(strings = {"337", "818", "211"})
    public void checkValidationFailDuplicate(String numbers) {

        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        Throwable exception = assertThrows(BizException.class, () -> {
            baseballNumbers.checkValidation();
        });
        assertEquals("DUPLICATE_NUMBER", exception.getMessage());
    }


}
