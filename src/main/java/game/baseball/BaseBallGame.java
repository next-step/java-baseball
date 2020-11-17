package game.baseball;

import game.baseball.domain.shared.GameStatus;
import game.baseball.domain.shared.ProcessStatus;
import game.baseball.ui.BaseBallGameController;

public class BaseBallGame {
	private static final BaseBallGameController controller = new BaseBallGameController();

	public static void main(String[] args) {
		do {
			start();
			run();
		} while (confirmRestart());
	}

	private static void start() {
		controller.startGame();
	}

	private static void run() {
		GameStatus gameStatus = GameStatus.CONTINUE;

		while (gameStatus == GameStatus.CONTINUE) {
			gameStatus = controller.runRound();
		}

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private static boolean confirmRestart() {
		return controller.confirmRestart() == ProcessStatus.RESTART;
	}
}
