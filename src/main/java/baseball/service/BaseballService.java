package baseball.service;

import baseball.domain.GameStatus;
import baseball.utils.HintUtils;
import baseball.utils.InputUtils;
import baseball.utils.RandomUtils;

public class BaseballService {

	public BaseballService() {
	}

	public int[] createRandomNumber() {
		return RandomUtils.createRandomNumber(1, 9);
	}

	public GameStatus playGame(int[] computerNumber) {
		boolean isContinue = true;

		while (isContinue) {
			int[] userNumber = InputUtils.getNumber(1, 9);
			isContinue = !HintUtils.isThreeStrike(userNumber, computerNumber);
		}

		return InputUtils.getGameStatus();
	}
}
