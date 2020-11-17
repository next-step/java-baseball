package game.baseball.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.baseball.application.BaseBallGameService;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.shared.GameStatus;
import game.baseball.domain.shared.Message;

public class BaseBallGameController {
	private final BaseBallGameService baseBallGameService;

	public BaseBallGameController() {
		this.baseBallGameService = new BaseBallGameService();
	}

	public void initGame() {
		baseBallGameService.init();
	}

	public boolean runGame() {
		try {
			int input = waitInputNumber(Message.INPUT_NUMBER);
			BaseBallResult baseBallResult = baseBallGameService.runGame(input);
			printGameResult(baseBallResult);

			return baseBallResult.isContinue();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return GameStatus.CONTINUE.isContinue();
		}
	}

	private void printGameResult(BaseBallResult baseBallResult) {
		System.out.println(baseBallResult.toString());
		if (baseBallResult.isWin()) {
			System.out.println(Message.THREE_STRIKE_GAME_OVER);
		}
	}

	public boolean waitConfirmRestart() {
		Boolean isRestart = null;

		while (isRestart == null) {
			isRestart = confirmRestart();
		}
		return isRestart;
	}

	private Boolean confirmRestart() {
		try {
			int input = waitInputNumber(Message.INPUT_ONE_OR_TWO_FOR_RESTART);
			return baseBallGameService.isRestart(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return null;
		}
	}

	private int waitInputNumber(String message) {
		Integer input = null;

		while (input == null) {
			System.out.print(message);
			input = inputInteger();
		}

		return input;
	}

	private Integer inputInteger() {
		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println(Message.INPUT_WRONG_VALUE);
			return null;
		}
	}
}
