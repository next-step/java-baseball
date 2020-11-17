package game.baseball;

import game.baseball.ui.BaseBallGameController;

public class BaseBallGame {
	private static final BaseBallGameController controller = new BaseBallGameController();

	public static void main(String[] args) {
		do {
			init();
			run();
		} while (confirm());
	}

	private static void init() {
		controller.initGame();
	}

	private static void run() {
		boolean isContinue = true;

		while (isContinue) {
			isContinue = controller.runGame();
		}
	}

	private static boolean confirm() {
		return controller.waitConfirmRestart();
	}
}
