package com.baseball.woowahan;

import java.util.Objects;

public class ScoreCalculatorAndPrinter {
	private int strikeCount;
	private int ballCount;

	public ScoreCalculatorAndPrinter() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public void calculate(String inputNumber, String randomNumber) {
		initCounts();
		String[] inputNumbers = inputNumber.split("");
		for (int i = 0; i < GameManager.GAME_LENGTH; i++) {
			checkStrike(randomNumber, i, inputNumbers[i]);
			checkBall(randomNumber, i, inputNumbers[i]);
		}
		printMessage();
	}

	public boolean isCompleted() {
		return Objects.equals(strikeCount, GameManager.GAME_LENGTH);
	}

	private void printMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		if (strikeCount > 0) {
			stringBuilder.append(strikeCount).append(" ").append(Message.STRIKE.getMessage()).append(" ");
		}
		if (ballCount > 0) {
			stringBuilder.append(ballCount).append(" ").append(Message.BALL.getMessage());
		}
		System.out.println(
			Objects.equals(stringBuilder.length(), 0) ? Message.NOTHING.getMessage() : stringBuilder.toString());
	}

	private void checkStrike(String randomNumber, int index, String input) {
		if (Objects.equals(index, randomNumber.indexOf(input))) {
			strikeCount++;
		}
	}

	private void checkBall(String randomNumber, int index, String input) {
		if (!Objects.equals(index, randomNumber.indexOf(input)) && randomNumber.contains(input)) {
			ballCount++;
		}
	}

	private void initCounts() {
		strikeCount = 0;
		ballCount = 0;
	}

}
