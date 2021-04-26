package com.nextstep.baseball;

public class BaseballApplication {
	private BaseballUI ui;
	private BaseballInning inning;
	public BaseballApplication() {
		ui = new BaseballUI();
	}
	public void start() {
		inning = new BaseballInning();
		inning.start();
		while(!inning.isEnd()) {
			int userBallCount = ui.getUserBallCount();
			String result = inning.pitchAndHit(userBallCount);
			ui.printResult(result);
		}
	}
	
	public boolean isContinue() {
		return ui.isContinue();
	}
	public static void main(String args[]) {
		BaseballApplication app = new BaseballApplication();
		do {
			app.start();
		} while (app.isContinue());
	}
}