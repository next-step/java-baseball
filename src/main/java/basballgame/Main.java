package basballgame;

import basballgame.game.BaseballGame;
import basballgame.ui.input.GameRestartInput;
import basballgame.ui.input.Input;

public class Main {
	public static void main(String[] args) {
		do {
			new BaseballGame().start();
		} while (wannaRestartGame());

		resourceClose();
	}

	public static boolean wannaRestartGame() {
		String userInput = GameRestartInput.input();
		return Integer.parseInt(userInput) == 1;
	}

	public static void resourceClose() {
		Input.close();
	}
}
