package game.baseball.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.baseball.application.BaseBallGameService;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.shared.GameStatus;
import game.baseball.domain.shared.ProcessStatus;

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
			int input = waiteInputNumber("숫자를 입력해주세요 : ");
			BaseBallResult baseBallResult = baseBallGameService.runRound(input);
			System.out.println(baseBallResult.toString());
			return GameStatus.valueOf(baseBallResult.isWin());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return GameStatus.CONTINUE;
		}
	}

	public ProcessStatus confirmRestart() {
		ProcessStatus processStatus = ProcessStatus.UNKNOWN;

		while (processStatus == ProcessStatus.UNKNOWN) {
			int input = waiteInputNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
			processStatus = ProcessStatus.valueOf(input);
		}

		return processStatus;
	}

	private int waiteInputNumber(String message) {
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
