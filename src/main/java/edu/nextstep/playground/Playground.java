package edu.nextstep.playground;

import edu.nextstep.game.BaseballGame;
import edu.nextstep.game.BaseballGamer;
import edu.nextstep.game.BaseballScore;

import edu.nextstep.ui.Ui;

public class Playground {
	public void play() {
		playBaseballGame();
	}

	private void playBaseballGame() {
		BaseballGame game = new BaseballGame();
		game.resetComputer();
		do {
			String inputNumber = Ui.inputThreeNumber();
			game.setPlayer(new BaseballGamer(inputNumber));
			game.resetScore();
			BaseballScore score = game.playToEnd();
			Ui.printMessageLine(score.toLocaleString());
		} while (!game.didWin());
	}
}