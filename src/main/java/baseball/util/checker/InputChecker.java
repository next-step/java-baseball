package baseball.util.checker;

import java.util.function.Predicate;

public interface InputChecker {

	Predicate<String> IS_VALID_NUM_FORMAT = input -> {
		boolean isValid = true;

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			isValid = false;
		}

		return isValid;
	};
	/**
	 * 유효한 입력인지 확인한다.
	 * @param input 사용자의 입력
	 * @return 유효하지 않은 입력이면 false를 반환
	 */
	boolean check(String input);
}
