package baseball;

import java.io.IOException;

import baseball.domain.Game;
import baseball.view.PrintMessage;

public class Application {

	public static void main(String[] args) throws IOException {
		Game game;
		do {
			game = new Game();
			game.start();
		} while (game.getGameStatus());

		PrintMessage.printEnd();
	}
}