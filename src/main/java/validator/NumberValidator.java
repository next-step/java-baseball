package validator;

import constant.NumberValidation;

public class NumberValidator {
	// 사용자로부터 입력한 수가 잘못되어 있는 지 확인
	public boolean validate(String number) {
		boolean isRightFlag = true;
		for (NumberValidation validation : NumberValidation.values()) {
			isRightFlag = isRightFlag && validateByCurrentFormat(validation, number);
		}
		return isRightFlag;
	}

	private static boolean validateByCurrentFormat(NumberValidation validation, String number) {
		if (!validation.getValidate().test(number)) {
			System.out.printf("입력 값 오류: %s\n", validation.getErrorMsg());
			return false;
		}
		return true;
	}

	public boolean isNotValidEndViewInput(String inputNumber) {
		return !NumberValidation.IsNotEmptyString.getValidate().test(inputNumber)
			|| !validateEndViewNumber(inputNumber);
	}

	// 게임에 이긴 다음에 선택지를 입력 받았을 때, 주어진 선택지 이외의 수를 입력했는 지 확인
	private static boolean validateEndViewNumber(String inputNumber) {
		return inputNumber.matches("^[1-2]$");
	}
}
