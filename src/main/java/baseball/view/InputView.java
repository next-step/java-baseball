package baseball.view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를입력해주세요: ";

	public static String getUserAnswer() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(INPUT_NUMBER_MESSAGE);
		return scanner.nextLine();
	}
}
