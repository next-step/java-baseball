
import java.io.InputStream;
import java.util.Scanner;

import number.Numbers;

public class View {
	private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

	private final Scanner scanner;

	public View(InputStream inputStream) {
		this.scanner = new Scanner(inputStream);
	}

	public Numbers inputNumbers() {
		System.out.print(INPUT_NUMBERS_MESSAGE);
		String inputString = scanner.next();
		return Numbers.of(inputString);
	}
}
