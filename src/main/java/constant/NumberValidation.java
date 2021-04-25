package constant;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import util.GameUtil;

public enum NumberValidation {
	IsNotEmptyString("입력 값이 비어있습니다", number -> number != null && !number.isEmpty()),
	IsRightNumberLength("자리수가 옳바르지 않습니다", number -> number.length() == GameUtil.LIMIT_DIGIT),
	IsRightNumberFormat("숫자로만 이루어져 있지 않습니다", number -> number.matches("^[1-9]+$")),
	IsDiffertNumber("중복되는 숫자가 존재합니다", NumberValidation::validateDifferentNumber);

	NumberValidation(String errorMsg, Predicate<String> validate) {
		this.errorMsg = errorMsg;
		this.validate = validate;
	}

	public Predicate<String> getValidate() {
		return this.validate;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	private static boolean validateDifferentNumber(String number) {
		Set<Character> digits = new HashSet<>();
		for (char digit : number.toCharArray()) {
			digits.add(digit);
		}
		return digits.size() == 3;
	}

	private final String errorMsg;
	private final Predicate<String> validate;
}
