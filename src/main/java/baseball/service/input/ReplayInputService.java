package baseball.service.input;

import java.util.Scanner;

import baseball.validator.ReplayInputValidator;

public class ReplayInputService implements InputService<Integer> {

	public static String INPUT_MESSAGE = "게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.";

	private final ReplayInputValidator validator = new ReplayInputValidator();

	@Override
	public Integer getUserInput() {
		System.out.println(INPUT_MESSAGE);
		Scanner scanner = new Scanner(System.in);
		int userInput;
		do {
			userInput = scanner.nextInt();
		} while (!validator.isValid(userInput));

		return userInput;
	}
}
