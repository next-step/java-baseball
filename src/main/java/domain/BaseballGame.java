package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import constants.Result;

public class BaseballGame {

	private final Scanner scanner = new Scanner(System.in);
	private BaseballNumber randomBaseballNumber = BaseballNumberFactory.generateRandomBaseballNumber();

	public void start() {
		boolean isGameEnd = false;
		ResultChecker checker = new ResultChecker();

		while (!isGameEnd) {
			BaseballNumber userBaseballNumber = requestUserBaseballNumber();
			Result result = checker.checkResult(userBaseballNumber, randomBaseballNumber);
			printResultMessage(result);
			isGameEnd = isGameOver(result);
			rePlay(result);
		}
	}

	private void printResultMessage(Result result) {
		System.out.println(result.getMessage());
	}

	private boolean isGameOver(Result result) {
		return result == Result.THREE_STRIKE && reTry() == 2;
	}

	private int reTry() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return scanner.nextInt();
	}

	private BaseballNumber requestUserBaseballNumber() {
		System.out.print("숫자를 입력해주세요: ");
		String[] numbers = checkDuplicated(checkLengthOver(scanner.next().trim().split("")));
		return new BaseballNumber(numbers[0], numbers[1], numbers[2]);
	}

	public String[] checkLengthOver(String[] numbers) {

		if (numbers.length > BaseballNumber.MAX_SIZE)
			throw new RuntimeException();

		return numbers;
	}

	public String[] checkDuplicated(String[] numbers) {
		Set<String> filter = new HashSet<>(Arrays.asList(numbers));

		if (filter.size() < BaseballNumber.MAX_SIZE)
			throw new RuntimeException();

		return numbers;
	}

	public void rePlay(Result result) {
		if (result == Result.THREE_STRIKE)
			randomBaseballNumber = BaseballNumberFactory.generateRandomBaseballNumber();
	}

}
