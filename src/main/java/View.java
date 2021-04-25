
import java.io.InputStream;
import java.util.Scanner;

import number.Numbers;
import number.NumbersMatchResult;

public class View {
	private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

	private final Scanner scanner;
	private final NumberMatchResultRenderer numberMatchResultRenderer;

	public View(InputStream inputStream, NumberMatchResultRenderer numberMatchResultRenderer) {
		this.scanner = new Scanner(inputStream);
		this.numberMatchResultRenderer = numberMatchResultRenderer;
	}

	public Numbers inputNumbers() {
		System.out.print(INPUT_NUMBERS_MESSAGE);
		String inputString = scanner.next();
		return Numbers.of(inputString);
	}

	public void renderResult(NumbersMatchResult numbersMatchResult) {
		final String description = numberMatchResultRenderer.render(numbersMatchResult);
		System.out.println(description);
	}
}
