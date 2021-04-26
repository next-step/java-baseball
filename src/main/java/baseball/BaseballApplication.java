package baseball;

import baseball.service.BaseballGameService;
import baseball.service.GameService;

public class BaseballApplication {
	public static void main(String[] args) {
		GameService gameService = new BaseballGameService();
		gameService.playGame();
	}
}
