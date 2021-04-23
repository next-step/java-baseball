import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ValidationUtil;

public class ValidationUtilTest {
    private static final ValidationUtil validationUtil = new ValidationUtil();

    @Test
    @DisplayName("3자리 숫자가 아닌 문자 입력 테스트")
    void is3DigitTest() {
        String number = "12";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));

        number = "12345";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 테스트")
    void isNumberTest() {
        String number = "!@#";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));

        number = "1@3";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));
    }

    @Test
    @DisplayName("사용자가 입력한 숫자에 0이 포함되어 있을 경우 테스트")
    void isContainsZeroTest() {
        String number = "012";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));

        number = "890";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));
    }

    @Test
    @DisplayName("사용자가 입력한 숫자에 중복 숫자가 있을 경우")
    void hasDuplicateNumber() {
        String number = "011";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));

        number = "101";
        Assertions.assertFalse(validationUtil.isCorrectNumber(number));
    }

    @Test
    @DisplayName("3자리 숫자 입력시의 테스트")
    void numberTest() {
        String number = "123";
        Assertions.assertTrue(validationUtil.isCorrectNumber(number));

        number = "789";
        Assertions.assertTrue(validationUtil.isCorrectNumber(number));
    }
}
