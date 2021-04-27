package baseball;

import java.io.FileNotFoundException;

import baseball.constant.GameStatus;
import baseball.domain.Game;
import baseball.domain.LoadableBaseballGame;
import baseball.view.BaseballGameView;
import baseball.view.LoadableBaseballGameView;

public class GameManager {
	public static final String EXIT_GAME = String.valueOf(GameStatus.EXIT.ordinal());

	public static void main(String[] args) throws FileNotFoundException {
		BaseballGameView gameView;
		do {
			gameView = new LoadableBaseballGameView();
			Game game = new LoadableBaseballGame(gameView);
			game.start();
		} while (isContinue(gameView));
	}

	private static boolean isContinue(BaseballGameView gameView) {
		return !EXIT_GAME.equals(gameView.continueGame());
	}
}
