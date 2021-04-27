package baseballgame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
	public static final int VALID_NUMBER_LENGTH = 3;

	private final String NUMBER_FROM_1_to_9_REG_EXP = "^[1-9]+$";
	private final String RESTART_GAME_STATUS = "1";
	private final String END_GAME_STATUS = "2";

	boolean validateStringNumbers(List<String> stringNumbers) {
		if (stringNumbers == null || stringNumbers.size() != VALID_NUMBER_LENGTH) {
			return false;
		}

		String join = String.join("", stringNumbers);
		Set<String> set = new HashSet<>(stringNumbers);

		return join.matches(NUMBER_FROM_1_to_9_REG_EXP) && set.size() == VALID_NUMBER_LENGTH;
	}

	boolean validateStrikeAndBallCounts(int strikeCount, int ballCount) {
		if ((strikeCount + ballCount) > 3 ||
			(strikeCount == 2 && ballCount == 1) ||
			(strikeCount == 3 && ballCount != 0)) {
			return false;
		}

		return true;
	}

	boolean validateRestartOrEndStatus(String restartOrEndStatus) {
		return restartOrEndStatus.equals(RESTART_GAME_STATUS) || restartOrEndStatus.equals(END_GAME_STATUS);
	}
}
