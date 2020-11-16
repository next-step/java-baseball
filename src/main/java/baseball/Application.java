package baseball;

import baseball.domain.game.BaseballGame;

public class Application {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.start();
	}
}
