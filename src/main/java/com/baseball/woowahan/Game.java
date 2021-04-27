package com.baseball.woowahan;

import com.baseball.woowahan.constant.Message;

public class Game {
	public static final int GAME_LENGTH = 3;
	private RandomGenerator randomGenerator;
	private ScoreCalculatorAndPrinter scoreCalculatorAndPrinter;
	private UserInputValidator userInputValidator;
	private String randomNumber;
	private boolean completed;
	private boolean finished;

	public boolean isCompleted() {
		return completed;
	}

	public boolean isFinished() {
		return finished;
	}

	public Game(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
		this.userInputValidator = new UserInputValidator();
		this.randomNumber = randomGenerator.makeRandomNumbers();
		this.scoreCalculatorAndPrinter = new ScoreCalculatorAndPrinter(randomNumber);
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
			this.completed = false;
		}
		if ("2".equals(restartFlag)) {
			this.finished = true;
		}
		if (!"1".equals(restartFlag) && !"2".equals(restartFlag)) {
			System.out.println(Message.INVALID_RESTART.getMessage());
		}
	}
}
