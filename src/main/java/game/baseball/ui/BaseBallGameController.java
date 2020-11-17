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

	public void startGame() {
		baseBallGameService.start();
	}

	public GameStatus runRound() {
		try {
			int input = waiteInputNumber();
			BaseBallResult baseBallResult = baseBallGameService.runRound(input);
			System.out.println(baseBallResult.toString());
			return GameStatus.valueOf(baseBallResult.isWin());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return GameStatus.CONTINUE;
		}
	}

	private int waiteInputNumber() {
		Integer input = null;

		while (input == null) {
			System.out.print("숫자를 입력해주세요 : ");
			input = inputInteger();
		}

		return input;
	}

	private Integer inputInteger() {
		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("잘못된 숫자를 입력하셨습니다.");
			return null;
		}
	}
}
