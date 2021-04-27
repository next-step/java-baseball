package basballgame.ui.input;

import java.util.Scanner;
import java.util.function.Predicate;

import basballgame.exception.NumberFormatValidationException;
import basballgame.ui.output.Output;

public class Input {
	private static Scanner scanner = new Scanner(System.in);
	static String withGuideAndValidator(String guideText, Predicate<String> validator) {

		String line;
		do {
			Output.print(guideText);
			line = readLine();
		} while (!validator.test(line));

		return line;
	}

	private static String readLine() {
		String line = scanner.nextLine();
		return line.trim();
	}

	public static void close() {
		try {
			scanner.close();
		} catch (RuntimeException e) {
			scanner.close();
		} finally {
			scanner.close();
		}
	}
}
