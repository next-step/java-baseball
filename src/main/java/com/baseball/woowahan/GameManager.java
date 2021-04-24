package com.baseball.woowahan;

import java.util.Scanner;

public class GameManager {
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.play();
	}

	public void play() {
		UserInput userInput = new UserInput();
		RandomGenerator randomGenerator = new RandomGenerator();
		ScoreCalculatorAndPrinter scoreCalculatorAndPrinter = new ScoreCalculatorAndPrinter();
		String randomNumber = randomGenerator.makeRandomNumbers();
		while (!scoreCalculatorAndPrinter.isCompleted()) {
			String inputNumber = userInput.start();
			scoreCalculatorAndPrinter.calculate(inputNumber, randomNumber);
		}
		choiceRestart();
	}

	private void choiceRestart() {
		System.out.println(Message.RESTART_OR_END.getMessage());
		Scanner scanner = new Scanner(System.in);
		if (scanner.nextInt() == 1) {
			play();
		}
		scanner.close();
	}
}
