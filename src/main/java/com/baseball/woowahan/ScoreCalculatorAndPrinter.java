package com.baseball.woowahan;

import java.util.Objects;

public class ScoreCalculatorAndPrinter {
	private int strikeCount = 0;
	private int ballCount = 0;

	public int calculate(String inputNumber, String randomNumber) {

		String[] inputNumbers = inputNumber.split("");
		for (int i = 0; i < UserInput.GAME_LENGTH; i++) {
			checkStrike(randomNumber, i, inputNumbers[i]);
			checkBall(randomNumber, i, inputNumbers[i]);
		}
		printMessage();
		return strikeCount;
	}

	private void printMessage() {

		StringBuilder stringBuilder = new StringBuilder();
		if (strikeCount > 0) {
			stringBuilder.append(strikeCount).append(" 스트라이크 ");
		}
		if (ballCount > 0) {
			stringBuilder.append(ballCount).append(" 볼");
		}
		System.out.println(Objects.equals(stringBuilder.length(), 0) ? "나싱" : stringBuilder.toString());
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

}
