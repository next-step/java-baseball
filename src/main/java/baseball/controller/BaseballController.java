package baseball.controller;

import baseball.domain.GameStatus;
import baseball.service.BaseballService;

public class BaseballController {
	private final BaseballService baseballService;

	public BaseballController(BaseballService baseballService) {
		this.baseballService = baseballService;
	}

	public void run() {
		GameStatus gameStatus = GameStatus.NEW;

		while (gameStatus.isContinue()) {
			int[] computerNumber = baseballService.createRandomNumber();
			gameStatus = baseballService.playGame(computerNumber);
		}
	}
}
