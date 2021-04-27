package baseball.controller;

import baseball.domain.Game;
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

		int[] numbers = readNumber();

		game.judge(numbers);
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
