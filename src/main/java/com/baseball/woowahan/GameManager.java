package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class GameManager {
	public static final int GAME_LENGTH = 3;
	private BufferedReader bufferedReader;

	public GameManager() {
		this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		try {
			gameManager.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void play(UserInputGenerator userInputGenerator, RandomGenerator randomGenerator,
		ScoreCalculatorAndPrinter scoreCalculatorAndPrinter) throws IOException {
		String randomNumber = randomGenerator.makeRandomNumbers();
		while (!scoreCalculatorAndPrinter.isCompleted()) {
			String inputNumber = userInputGenerator.returnInputNumber();
			scoreCalculatorAndPrinter.calculate(inputNumber, randomNumber);
		}
		System.out.println(Message.COMPLETE.getMessage());
		choiceRestart();
	}

	private void start() throws IOException {
		play(new UserInputGenerator(bufferedReader, new UserInputValidator()), new RandomGenerator(),
			new ScoreCalculatorAndPrinter());
	}

	private void choiceRestart() throws IOException {
		System.out.println(Message.RESTART_OR_END.getMessage());
		if (Objects.equals(bufferedReader.readLine(), "1")) {
			start();
		}
	}

}
