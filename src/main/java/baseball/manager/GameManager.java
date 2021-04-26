package baseball.manager;

import static baseball.util.PrinterUtil.*;

import baseball.enums.ReGameType;
import baseball.game.BaseballGame;
import baseball.game.Game;
import baseball.util.ScannerUtil;

public class GameManager {
	private Game game;

	public GameManager() {
		this.game = new BaseballGame();
	}

	public void runGame() {
		game.play();

		while (isReplayGame()) {
			replay();
		}
	}

	private void replay() {
		this.game = new BaseballGame();
		game.play();
	}

	private boolean isReplayGame() {
		printReGame();
		String scanInput = ScannerUtil.getUserInput();
		return isMatchStrReGame(scanInput);
	}

	private boolean isMatchStrReGame(String str) {
		return str.equals(ReGameType.RE_GAME.getTypeNum());
	}
}
