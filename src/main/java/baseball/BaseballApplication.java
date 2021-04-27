package baseball;

import baseball.service.game.BaseballPlayService;
import baseball.service.game.GameService;

public class BaseballApplication {

	public static void main(String[] args) {
		GameService gameService = new BaseballPlayService();
		gameService.playGame();
	}
}
