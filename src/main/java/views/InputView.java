package views;

import java.util.Scanner;

public class InputView {
	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public String inputAnswerNumber() {
		System.out.print(Constants.INPUT_ANSWER);
		return scanner.next();
	}
}
