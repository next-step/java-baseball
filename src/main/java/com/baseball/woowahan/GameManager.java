package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * 게임 시작, 관리 모듈
 */
public class GameManager {
	public static final int GAME_LENGTH = 3;
	private final String CONTINUE_FLAG = "1";
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

	private void play(UserInputGenerator userInputGenerator, RandomGenerator randomGenerator) throws IOException {
		String randomNumber = randomGenerator.makeRandomNumbers();
		ScoreCalculatorAndPrinter scoreCalculatorAndPrinter = new ScoreCalculatorAndPrinter(randomNumber);
		while (!scoreCalculatorAndPrinter.isCompleted()) {
			String inputNumber = userInputGenerator.returnInputNumber();
			scoreCalculatorAndPrinter.calculate(inputNumber);
		}
		System.out.println(Message.COMPLETE.getMessage());
		choiceRestart();
	}

	private void start() throws IOException {
		play(new UserInputGenerator(bufferedReader, new UserInputValidator()), new RandomGenerator());
	}

	private void choiceRestart() throws IOException {
		System.out.println(Message.RESTART_OR_END.getMessage());
		if (Objects.equals(bufferedReader.readLine(), CONTINUE_FLAG)) {
			start();
		}
	}

}
