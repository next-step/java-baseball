package constant;

import java.util.function.Predicate;

import util.GameUtil;

public enum NumberValidation {
	IsNotEmptyString("입력 값이 비어있습니다", number -> number != null && !number.isEmpty()),
	IsRightNumberLength("자리수가 옳바르지 않습니다", number -> number.length() == GameUtil.LIMIT_DIGIT),
	IsRightNumberFormat("숫자로만 이루어져 있지 않습니다", number -> number.matches("^[1-9]+$"));

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

	private final String errorMsg;
	private final Predicate<String> validate;
}
