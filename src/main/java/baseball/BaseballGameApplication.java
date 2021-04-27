package baseball;

import baseball.domain.Game;
import baseball.domain.GameStatus;
import baseball.domain.internal.BaseballGameImpl;
import baseball.domain.internal.BaseballUmpireImpl;
import baseball.presentation.ConsoleDisplayImpl;
import baseball.presentation.ConsoleInputImpl;

public class BaseballGameApplication {

	public static void main(String... args) {
		Game baseballGame = new BaseballGameImpl(new ConsoleDisplayImpl(), new ConsoleInputImpl());
		baseballGame.start(new BaseballUmpireImpl());

		while (GameStatus.CONTINUE == baseballGame.getGameStatus()) {
			baseballGame.init();
			baseballGame.play();
		}
	}
}
