package com.woowahan.camp;

import java.util.Scanner;

import com.woowahan.camp.constant.Message;
import com.woowahan.camp.constant.RetryOrExit;
import com.woowahan.camp.model.BaseballNumber;
import com.woowahan.camp.model.GameResult;
import com.woowahan.camp.util.ValidationUtil;

public class BaseballGame {

	public static void main(String[] args) {
		runGame();
	}

	private static void runGame() {
		Scanner scanner = new Scanner(System.in);
		BaseballNumber computerNumber = BaseballNumber.getRandomBaseballNumber();
		GameResult gameResult;
		do {
			gameResult = getUserInput(scanner, computerNumber);
			System.out.println(gameResult.getResultMsg());
		} while (!gameResult.isWin());
		retryOrExit(scanner);
	}

	private static void retryOrExit(Scanner scanner) {
		System.out.println(Message.RETRY_OR_EXIT_MSG);
		String inputValue = scanner.nextLine();
		if (RetryOrExit.RETRY.equals(inputValue)) {
			runGame();
		}
		if (RetryOrExit.EXIT.equals(inputValue)) {
			System.exit(0);
		}
		retryOrExit(scanner);
	}

	private static GameResult getUserInput(Scanner scanner, BaseballNumber computerNumber) {
		System.out.println(Message.REQUEST_INPUT_MSG);
		String inputValue = scanner.nextLine();
		if (ValidationUtil.isNotNumber(inputValue) || ValidationUtil.isNotLengthThree(inputValue)) {
			System.out.println(Message.VALIDATION_ERR_MSG);
			return getUserInput(scanner, computerNumber);
		}
		BaseballNumber inputNumber = BaseballNumber.getBaseballNumber(inputValue);
		return computerNumber.checkStrikeAndBall(inputNumber);
	}

}
