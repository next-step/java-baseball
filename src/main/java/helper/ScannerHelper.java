package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerHelper {
	private static ScannerHelper scannerHelper = new ScannerHelper();
	private Scanner scanner;

	private ScannerHelper() {
		scanner = new Scanner(System.in);
	}

	public static ScannerHelper getInstance() {
		return scannerHelper;
	}

	public List<Integer> getGuess() {
		String inputValue = scanner.nextLine();
		final List<Integer> guessList = new ArrayList<>();
		final int length = inputValue.length() > 3 ? 3 : inputValue.length();

		for (int i = 0; i < length; i++) {
			guessList.add(inputValue.charAt(i) - '0');
		}

		return guessList;
	}
}
