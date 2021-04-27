package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Result;
import baseball.domain.Validator;
import baseball.view.View;

public class BaseballGameController {

	private Game game;
	private View view;

	public BaseballGameController(Game game, View view) {
		this.game = game;
		this.view = view;
	}

	public void start() {
		game.start();
		play();
	}

	private void showResult(Result result) {
		if(result.isSuccess()) {
			view.showEndGameMessage();
			return;
		}

		view.showHint(result);
	}

	private void play() {
		boolean isSuccess;
		do {
			int[] numbers = readNumber();
			Result result = game.judge(numbers);
			isSuccess = result.isSuccess();
			showResult(result);
		} while(!isSuccess);
		view.showRestartGameMessage();
		runCommand(view.readInput());
	}

	void runCommand(String cmd) {
		if(cmd.equals("1")) {
			start();
			return;
		}

		if(cmd.equals("2")) {
			finishGame();
			return;
		}
	}

	void finishGame() {
		System.exit(0);
	}

	private int[] readNumber() {
		boolean isValid;
		int[] numbers = new int[0];
		do {
			view.showInputNumberMessage();
			String input = view.readInput();
			isValid = Validator.isValidLength(input);
			if(!isValid) continue;

			numbers = toIntArray(input);
			isValid = isValid & Validator.isInRange(numbers);

		} while (!isValid);

		return numbers;
	}

	private int[] toIntArray(String text) {
		int len = text.length();
		int[] numbers = new int[len];
		for (int i = 0; i < len; i++) {
			numbers[i] = text.charAt(i) - '0';
		}

		return numbers;
	}
}
