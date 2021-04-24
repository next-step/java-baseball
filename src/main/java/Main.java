import baseball.BaseballGame;

import static config.Property.NUMBER_SIZE;

public class Main {

	public static void main(String[] args) {
		BaseballGame baseGame = new BaseballGame(NUMBER_SIZE);

		do {
			baseGame.doGame();
			baseGame.askRestart();
		} while (baseGame.isRestart());
	}
}
