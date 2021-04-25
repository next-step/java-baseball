import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.ValidationUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationUtilTest {
    private static final ValidationUtil validationUtil = new ValidationUtil();

    @ParameterizedTest(name = "3자리 숫자가 아닌 문자 입력 테스트 - {index}: {0}")
    @CsvSource(value = {"12:false", "12345:false"}, delimiter = ':')
    @DisplayName("3자리 숫자가 아닌 문자 입력 테스트")
    void is3DigitTest(String inputNumber, boolean isCorrect) {
        assertThat(validationUtil.isCorrectNumber(inputNumber)).isEqualTo(isCorrect);
    }

    @ParameterizedTest(name = "숫자가 아닌 문자 입력 테스트 - {index}: {0}")
    @CsvSource(value = {"!@#:false", "1@3:false"}, delimiter = ':')
    void isNumberTest(String inputNumber, boolean isCorrect) {
        assertThat(validationUtil.isCorrectNumber(inputNumber)).isEqualTo(isCorrect);
    }

    @ParameterizedTest(name = "사용자가 입력한 숫자에 0이 포함되어 있을 경우 테스트 - {index}: {0}")
    @CsvSource(value = {"012:false", "890:false"}, delimiter = ':')
    void isContainsZeroTest(String inputNumber, boolean isCorrect) {
        assertThat(validationUtil.isCorrectNumber(inputNumber)).isEqualTo(isCorrect);
    }

    @ParameterizedTest(name = "사용자가 입력한 숫자에 중복 숫자가 있을 경우 테스트 - {index}: {0}")
    @CsvSource(value = {"011:false", "101:false"}, delimiter = ':')
    void hasDuplicateNumber(String inputNumber, boolean isCorrect) {
        assertThat(validationUtil.isCorrectNumber(inputNumber)).isEqualTo(isCorrect);
    }

    @ParameterizedTest(name = "올바른 3자리 숫자 입력시의 테스트 - {index}: {0}")
    @CsvSource(value = {"123:true", "789:true"}, delimiter = ':')
    void numberTest(String inputNumber, boolean isCorrect) {
        assertThat(validationUtil.isCorrectNumber(inputNumber)).isEqualTo(isCorrect);
    }

    @ParameterizedTest(name = "게임 진행 여부 입력 문자가 1과 2가 아닐 경우 테스트 - {index}: {0}")
    @ValueSource(strings = {"#", "4"})
    void continueWrongInputTest(String inputNumber) {
        assertFalse(validationUtil.isCorrectContinueAnswer(inputNumber));
    }

    @ParameterizedTest(name = "게임 진행 여부 정상값 입력 테스트 - {index}: {0}")
    @ValueSource(strings = {"1", "2"})
    void continueCorrectInputTest(String inputNumber) {
        assertTrue(validationUtil.isCorrectContinueAnswer(inputNumber));
    }
}
