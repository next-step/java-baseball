package baseball.validator;

public class UserAnswerValidator implements InputValidator<String> {

	public static String REGEX_NON_DUP_THREE_LENGTH_ONE_TO_NINE = "^(?!.*(.).*\\1)[1-9]{3}$";
	public static String NOT_VALID_MESSAGE = "1~9로 이루어진 중복되지 않는 3자리 숫자를 입력해주세요";

	@Override
	public boolean isValid(String input) {
		boolean isValid = input.matches(REGEX_NON_DUP_THREE_LENGTH_ONE_TO_NINE);
		if (!isValid) {
			System.out.println(NOT_VALID_MESSAGE);
		}
		return isValid;
	}
}
