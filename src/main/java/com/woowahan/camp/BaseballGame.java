package com.woowahan.camp;

import java.util.Scanner;

import com.woowahan.camp.constant.Message;
import com.woowahan.camp.model.BaseballNumber;
import com.woowahan.camp.model.GameResult;

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
		} while (!gameResult.isWin());
		retryOrExit(scanner);
	}

	private static void retryOrExit(Scanner scanner) {
		System.out.println(Message.RETRY_OR_EXIT_MSG);
		throw new RuntimeException("재시도 입력 값 받아 검증 후 로직");
	}

	private static GameResult getUserInput(Scanner scanner, BaseballNumber computerNumber) {
		System.out.println(Message.REQUEST_INPUT_MSG);
		throw new RuntimeException("입력값 validation 후 사용자 데이터 받아 결과값 반환");
	}

}
