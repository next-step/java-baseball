import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import constant.NumberValidation;

@DisplayName("야구 게임에 이용되는 수에 대한 검증 테스트")
public class ValidationTest {
	@DisplayName("숫자가 공백이거나 null이었을 때 테스트")
	@ParameterizedTest
	@EmptySource
	@NullSource
	public void numberEmptyTest(String digits) {
		Predicate<String> validate = NumberValidation.IsNotEmptyString.getValidate();
		Assertions.assertFalse(validate.test(digits));
	}

	@DisplayName("숫자가 공백이거나 null이 아니었을 때 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "12", "ab"})
	public void numberNotEmptyTest(String digits) {
		Predicate<String> validate = NumberValidation.IsNotEmptyString.getValidate();
		Assertions.assertTrue(validate.test(digits));
	}

	@DisplayName("각 자리의 수가 맞는 지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"123", "235", "abc"})
	public void numberCountRightTest(String digits) {
		Predicate<String> validate = NumberValidation.IsRightNumberLength.getValidate();
		Assertions.assertTrue(validate.test(digits));
	}

	@DisplayName("각 자리의 수가 안 맞을 시 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", "12", "23554", "adsa"})
	public void numberCountNotRightTest(String digits) {
		Predicate<String> validate = NumberValidation.IsRightNumberLength.getValidate();
		Assertions.assertFalse(validate.test(digits));
	}

	@DisplayName("1~9의 숫자로만 이루어져 있는 지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"123", "235", "3212"})
	public void numberRightFormatTest(String digits) {
		Predicate<String> validate = NumberValidation.IsRightNumberFormat.getValidate();
		Assertions.assertTrue(validate.test(digits));
	}

	@DisplayName("1~9의 숫자로만 이루어져 있지 않는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"a", "abc", "sds", "!@a22", "102"})
	public void numberNotRightFormatTest(String digits) {
		Predicate<String> validate = NumberValidation.IsRightNumberFormat.getValidate();
		Assertions.assertFalse(validate.test(digits));
	}
}
