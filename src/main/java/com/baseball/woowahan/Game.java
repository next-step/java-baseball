package com.baseball.woowahan;

import com.baseball.woowahan.constant.Message;

public class Game {
	public static final int DEFAULT_LENGTH = 3;
	public static int gameLength;
	private ScoreCalculatorAndPrinter scoreCalculatorAndPrinter;
	private UserInputValidator userInputValidator;
	private boolean completed;
	private boolean finished;

	public boolean isCompleted() {
		return completed;
	}

	public boolean isFinished() {
		return finished;
	}

	public Game() {
		this(DEFAULT_LENGTH);
	}

	public Game(int inputLength) {
		gameLength = inputLength;
		this.userInputValidator = new UserInputValidator();
		this.scoreCalculatorAndPrinter = new ScoreCalculatorAndPrinter(new RandomGenerator());
		completed = false;
		finished = false;
	}

	public void processInput(String input) {
		if (userInputValidator.isValid(input)) {
			scoreCalculatorAndPrinter.calculate(input);
			completed = scoreCalculatorAndPrinter.isCompleted();
		}
	}

	public void choiceRestart(String restartFlag) {
		if ("1".equals(restartFlag)) {
			initGame();
		}
		if ("2".equals(restartFlag)) {
			this.finished = true;
		}
		if (!"1".equals(restartFlag) && !"2".equals(restartFlag)) {
			System.out.println(Message.INVALID_RESTART.getMessage());
		}
	}

	private void initGame() {
		this.completed = false;
		scoreCalculatorAndPrinter.setNewRandomNumber();
	}
}
