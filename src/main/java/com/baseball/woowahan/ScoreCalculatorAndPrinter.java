package com.baseball.woowahan;

import java.util.Objects;

/**
 * 점수 계산, 출력 모듈
 * @param : String randomNumber
 */
public class ScoreCalculatorAndPrinter {
	private int strikeCount;
	private int ballCount;
	private String randomNumber;

	public ScoreCalculatorAndPrinter(String randomNumber) {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.randomNumber = randomNumber;
	}

	public void calculate(String inputNumber) {
		initCounts();
		String[] inputNumbers = inputNumber.split("");
		for (int i = 0; i < GameManager.GAME_LENGTH; i++) {
			checkStrike(i, inputNumbers[i]);
			checkBall(i, inputNumbers[i]);
		}
		printMessage();
	}

	public boolean isCompleted() {
		return Objects.equals(this.strikeCount, GameManager.GAME_LENGTH);
	}

	private void printMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		if (this.strikeCount > 0) {
			stringBuilder.append(this.strikeCount).append(" ").append(Message.STRIKE.getMessage()).append(" ");
		}
		if (this.ballCount > 0) {
			stringBuilder.append(this.ballCount).append(" ").append(Message.BALL.getMessage());
		}
		System.out.println(
			Objects.equals(stringBuilder.length(), 0) ? Message.NOTHING.getMessage() : stringBuilder.toString());
	}

	private void checkStrike(int index, String input) {
		if (Objects.equals(index, this.randomNumber.indexOf(input))) {
			strikeCount++;
		}
	}

	private void checkBall(int index, String input) {
		if (!Objects.equals(index, this.randomNumber.indexOf(input)) && this.randomNumber.contains(input)) {
			ballCount++;
		}
	}

	private void initCounts() {
		strikeCount = 0;
		ballCount = 0;
	}

}
