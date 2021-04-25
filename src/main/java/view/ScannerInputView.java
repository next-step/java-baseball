package view;

import java.io.InputStream;
import java.util.Scanner;

import number.Numbers;

public class ScannerInputView implements InputView {

	private final Scanner scanner;

	public ScannerInputView(InputStream inputStream) {
		this.scanner = new Scanner(inputStream);
	}

	@Override
	public Numbers inputNumbers() {
		String inputString = scanner.next();
		return Numbers.of(inputString);
	}

	@Override
	public String inputRerunGameFlag() {
		return scanner.next();
	}

}
