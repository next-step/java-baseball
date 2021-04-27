package baseball.util.checker;

import java.util.function.Predicate;

public class GameContinueInputCheckImpl implements InputChecker {
	Predicate<String> isValidNum = input -> {
		int value = Integer.parseInt(input);
		return value == 1 || value == 2;
	};

	@Override
	public boolean check(String input) {
		return IS_VALID_NUM_FORMAT.and(isValidNum).test(input);
	}
}
