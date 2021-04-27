package jbh.numberbaseball;

import jbh.view.BaseballUI;

public class BaseballGame {

	private BaseballUI ui;
	private DefenceTeam defenceTeam;
	private Umpire umpire;
	private boolean playGame;

	public BaseballGame() {
		this.ui = new BaseballUI();
		this.defenceTeam = new DefenceTeam();
		this.umpire = new Umpire();
		this.playGame = true;
	}

	public void playGame() {
		ui.displayInputRequestMessage();
		String userInputBall = ui.getUserInputText();
		GameResult gameResult = umpire.judgePitching(defenceTeam.getBall(), userInputBall);
		ui.displayGameResult(gameResult);
		if (gameResult.isOut()) {
			ui.displayEndingMessage();
			choiceGamePlay();
		}
	}

	public void choiceGamePlay() {
		ui.displayMenu();
		String input = ui.getUserInputText();
		if (input.equals("2")) {
			this.playGame = false;
			return;
		}
		requestNewDefenceBall();
	}

	public boolean isPlayGame() {
		return playGame;
	}

	private void requestNewDefenceBall() {
		this.defenceTeam.initNewBall();
	}
}
