package study.mock;

import java.util.Scanner;

public class MockScanner {

	final Scanner sc;
	public MockScanner() {
		sc = new Scanner(System.in);
	}

	public boolean isInputYes() {

		String input = sc.next();

		return "yes".equalsIgnoreCase(input);
	}
}
