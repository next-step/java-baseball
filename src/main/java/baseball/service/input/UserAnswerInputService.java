package baseball.service.input;

import java.util.List;
import java.util.Scanner;

import baseball.utils.StringUtil;
import baseball.validator.UserAnswerValidator;

public class UserAnswerInputService implements InputService<List<Integer>> {

	public static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	private final UserAnswerValidator validator = new UserAnswerValidator();

	@Override
	public List<Integer> getUserInput() {
		System.out.print(INPUT_MESSAGE);
		Scanner scanner = new Scanner(System.in);
		String userInput;
		do {
			userInput = scanner.nextLine();
		} while (!validator.isValid(userInput));

		return StringUtil.convertStringToIntegerList(userInput);
	}
}
