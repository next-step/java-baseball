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
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		if (scanner.nextInt() == 1) {
			play();
		}
		scanner.close();
	}
}
