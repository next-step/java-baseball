package baseball;

import baseball.game.Game;

public class BaseballApplication {
	public static void main(String[] args) {
		Game game = Game.onGame();
		game.playGame();
	}
}
