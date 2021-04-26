package baseball.view;

import java.util.Scanner;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersFactory;
import baseball.exception.InputValueException;
import baseball.util.StringUtils;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요:";

	private static final String REPLAY_BASEBALL_NUMBERS_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private InputView() { }

	public static BaseballNumbers inputBaseballNumbers() {
		System.out.print(INPUT_BASEBALL_NUMBERS_MESSAGE);

		String inputValue = SCANNER.nextLine();

		validateNumber(inputValue);

		return BaseballNumbers.newBaseballNumbers(BaseballNumbersFactory.create(inputValue));
	}

	private static void validateNumber(String value) {
		if (!StringUtils.isNumber(value)) {
			throw new InputValueException("입력 값이 숫자가 아닙니다.");
		}
	}

	public static boolean inputReplayBaseBallGame() {
		System.out.println(REPLAY_BASEBALL_NUMBERS_MESSAGE);

		return "1".equals(SCANNER.nextLine());
	}

}
