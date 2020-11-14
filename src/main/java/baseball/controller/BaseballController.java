package baseball.controller;

import baseball.domain.Game;
import baseball.domain.GameHint;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {
	public static void start() {
		Game game = new Game(new GameNumberRandomGenerator());

		while (!game.isFinished()) {
			String userAnswer = InputView.getUserAnswer();
			GameHint gameHint = game.inputUserAnswer(userAnswer);
			printHint(gameHint);
		}

		ResultView.printFinish();
	}

	private static void printHint(GameHint gameHint) {
		if (gameHint == null) {
			return;
		}

		printNothing(gameHint);
		printStrikeCount(gameHint);
		printBallCount(gameHint);
	}

	private static void printNothing(GameHint gameHint) {
		if (gameHint.isNothing()) {
			ResultView.printNothing();
		}
	}

	private static void printBallCount(GameHint gameHint) {
		int ballCount = gameHint.countBall();
		if (ballCount > 0) {
			ResultView.printBallCount(ballCount);
		}
	}

	private static void printStrikeCount(GameHint gameHint) {
		int strikeCount = gameHint.countStrike();
		if (strikeCount > 0) {
			ResultView.printStrikeCount(strikeCount);
		}
	}
}
