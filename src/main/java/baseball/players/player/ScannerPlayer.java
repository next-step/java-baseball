package baseball.players.player;

import java.util.List;
import java.util.Scanner;

import baseball.utils.DataConvertUtils;
import baseball.validator.NumberValidator;

public class ScannerPlayer implements Player {
	private Scanner scanner = new Scanner(System.in);
	private NumberValidator numberValidator = new NumberValidator();

	@Override
	public List<Integer> getRequestNumbers() {
		String numbers = scanner.nextLine();
		if (!numberValidator.validate(numbers))
			throw new IllegalArgumentException("invalid requestNumbers");

		return DataConvertUtils.convertToIntegerArrays(numbers);
	}

	@Override
	public boolean isContinue() {
		String command = scanner.nextLine();
		return "1".equals(command);
	}
}
