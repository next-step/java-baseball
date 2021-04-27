package com.baseball.woowahan;

import java.util.Objects;

import com.baseball.woowahan.constant.Message;

/**
 * 점수 계산, 출력 모듈
 * @param : String randomNumber
 */
public class ScoreCalculatorAndPrinter {
	private int strikeCount;
	private int ballCount;
	private RandomGenerator randomGenerator;
	private String randomNumber;

	public ScoreCalculatorAndPrinter(RandomGenerator randomGenerator) {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.randomGenerator = randomGenerator;
		this.randomNumber = randomGenerator.makeRandomNumbers();
	}

	public void setNewRandomNumber() {
		randomNumber = randomGenerator.makeRandomNumbers();
	}

	public void calculate(String inputNumber) {
		initCounts();
		String[] inputNumbers = inputNumber.split("");
		for (int i = 0; i < Game.gameLength; i++) {
			checkStrike(i, inputNumbers[i]);
			checkBall(i, inputNumbers[i]);
		}
		printMessage();
	}

	public boolean isCompleted() {
		if (Objects.equals(this.strikeCount, Game.gameLength)) {
			System.out.println(Message.COMPLETE.getMessage());
			return true;
		}
		return false;
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
