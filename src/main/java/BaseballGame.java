import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import constants.Result;

public class BaseballGame {

	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		game.start();
	}

	public void start() {
		boolean isGameEnd = false;
		ResultChecker checker = new ResultChecker();
		BaseballNumber randomBaseballNumber = BaseballNumberFactory.generateRandomBaseballNumber();

		while (!isGameEnd) {
			BaseballNumber userBaseballNumber = requestInput();
			Result result = checker.checkResult(userBaseballNumber, randomBaseballNumber);
			System.out.println(result.getMessage());
			isGameEnd = isGameOver(result);
		}
	}

	private boolean isGameOver(Result result) {
		return result == Result.THREE_STRIKE && reTry() == 2;
	}

	private int reTry() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return scanner.nextInt();
	}

	private BaseballNumber requestInput() {
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

	public BaseballNumber rePlay() {
		return BaseballNumberFactory.generateRandomBaseballNumber();
	}

}
