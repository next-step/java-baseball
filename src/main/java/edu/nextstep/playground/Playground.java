package edu.nextstep.playground;

import edu.nextstep.game.BaseballGame;
import edu.nextstep.game.BaseballGamer;
import edu.nextstep.game.BaseballScore;

import edu.nextstep.ui.Ui;

public class Playground {
	public void play() {
		do {
			playBaseballGame();
		} while (isContinue(Ui.inputForContinue()));
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
		Ui.printBaseballGameVictory(game.getSelectedNumberSize());
	}

	public boolean isContinue(String choice) {
		if ("1".equals(choice)) {
			return true;
		}
		if ("2".equals(choice)) {
			return false;
		}
		return false;
	}
}