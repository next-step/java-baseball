package game.baseball;

import game.baseball.domain.shared.GameStatus;
import game.baseball.ui.BaseBallGameController;

public class BaseBallGame {
	private static final BaseBallGameController controller = new BaseBallGameController();

	public static void main(String[] args) {
		start();
		run();
	}

	private static void start() {
		controller.startGame();
	}

	private static void run() {
		GameStatus gameStatus = GameStatus.CONTINUE;

		while (gameStatus == GameStatus.CONTINUE) {
			gameStatus = controller.runRound();
		}
	}
}
