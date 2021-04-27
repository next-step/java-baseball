package baseball.validator;

public class ReplayInputValidator implements InputValidator<Integer> {

	public static String NOT_VALID_MESSAGE = "1이나 2를 입력해주세요";

	@Override
	public boolean isValid(Integer input) {
		boolean isValid = input == 1 || input == 2;
		if (!isValid) {
			System.out.println(NOT_VALID_MESSAGE);
		}
		return isValid;
	}
}
