package validator;

import constant.NumberValidation;

public class NumberValidator {
	public boolean validate(String number) {
		boolean isRightFlag = true;
		for (NumberValidation validation : NumberValidation.values()) {
			isRightFlag = isRightFlag && validateByCurrentFormat(validation, number);
		}
		return isRightFlag;
	}

	private static boolean validateByCurrentFormat(NumberValidation validation, String number) {
		if (!validation.getValidate().test(number)) {
			System.out.printf("입력 값 오류: %s\n\n", validation.getErrorMsg());
			return false;
		}
		return true;
	}
}
