package baseball.domain;

import baseball.service.BaseballGameService;
import baseball.util.UserInput;

public class BaseballGame {

	private static final UserInput input = new UserInput();

	public static void start() {
		do {
			playBallGame(new BaseballGoalNumber());
		} while (isContinue());
	}

	private static boolean isContinue() {

		return BaseballGameService.isStartGame(input.userInputNumber());
	}

	private static void playBallGame(BaseballGoalNumber baseballGoalNumber) {

		// input.userGameNumber();
	}
}
