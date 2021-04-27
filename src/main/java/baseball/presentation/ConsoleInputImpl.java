package baseball.presentation;

import java.util.Scanner;

public class ConsoleInputImpl implements Input {

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
