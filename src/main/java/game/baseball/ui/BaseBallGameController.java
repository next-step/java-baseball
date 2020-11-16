package game.baseball.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.baseball.application.BaseBallGameService;

public class BaseBallGameController {
	private final BaseBallGameService baseBallGameService;

	public BaseBallGameController() {
		this.baseBallGameService = new BaseBallGameService();
	}

	public void startGame() {
		baseBallGameService.start();
	}

	public void inputAndRunRound() {
		int input = waiteInputNumber();

		try {
			baseBallGameService.runRound(input);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return;
		}

		//라운드 결과를 받아서 출력
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
		Integer number = null;

		try {
			Scanner scanner = new Scanner(System.in);
			number = scanner.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("잘못된 숫자를 입력하셨습니다.");
		}

		return number;
	}
}
