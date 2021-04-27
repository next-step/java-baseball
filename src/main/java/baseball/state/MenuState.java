package baseball.state;

import baseball.Game;
import baseball.io.Display;
import baseball.io.Keyboard;

public class MenuState implements State {

	private Game game;

	public MenuState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		boolean coin = insert();
		if (coin) {
			start();
		}
		return coin;
	}

	private boolean insert() {
		Display.start();
		return !Keyboard.read().equals("n");
	}

	public void start() {
		game.createOpponent();
		game.onInningState();
	}

}
