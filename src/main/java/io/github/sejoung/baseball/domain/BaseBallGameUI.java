package io.github.sejoung.baseball.domain;

import static io.github.sejoung.baseball.constants.GameMessage.*;
import static io.github.sejoung.baseball.constants.GameStatus.*;
import static io.github.sejoung.baseball.constants.GameStatus.RESTART;

import java.util.Scanner;

import io.github.sejoung.baseball.constants.GameStatus;
import io.github.sejoung.baseball.util.ComputerNumber;

public class BaseBallGameUI {

	private final Scanner scanner;

	private GameStatus status;

	private boolean endGameFlag = false;

	public BaseBallGameUI(Scanner scanner) {
		this.scanner = scanner;
	}

	public void playGame() {
		BaseBallGame baseBallGame = new BaseBallGame(ComputerNumber.getNumber(3));
		while (!endGameFlag) {
			printInput();
			printMessage(baseBallGame.play(scanner.next()));
			changeStatus(baseBallGame.getStatus());
		}
		restart();
	}

	private void changeStatus(GameStatus status) {
		this.status = status;
		this.endGameFlag = isEndGame();
	}

	private void restart() {
		if (RESTART.equals(status)) {
			playGame();
		}
	}

	private boolean isEndGame() {
		return !DOING.equals(status);
	}

	private void printInput() {
		System.out.print(INPUT.getMessage());
	}

	private void printMessage(String message) {
		System.out.println(message);
	}
}
