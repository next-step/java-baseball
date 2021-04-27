package baseball.service;

import baseball.domain.GameStatus;
import baseball.utils.HintUtils;
import baseball.utils.InputUtils;
import baseball.utils.RandomUtils;

public class BaseballService {
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 9;

	public BaseballService() {
	}

	public int[] createRandomNumber() {
		return RandomUtils.createRandomNumber(MIN_VALUE, MAX_VALUE);
	}

	public GameStatus playGame(int[] computerNumber) {
		boolean isContinue = true;

		while (isContinue) {
			int[] userNumber = InputUtils.getNumber(MIN_VALUE, MAX_VALUE);
			isContinue = !HintUtils.isThreeStrike(userNumber, computerNumber);
		}

		return InputUtils.getGameStatus();
	}
}
