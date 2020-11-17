package game.baseball.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.baseball.application.BaseBallGameService;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.shared.GameStatus;

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
			int input = waitInputNumber("숫자를 입력해주세요 : ");
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
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
			int input = waitInputNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
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
			System.out.println("잘못된 값을 입력하셨습니다.");
			return null;
		}
	}
}
