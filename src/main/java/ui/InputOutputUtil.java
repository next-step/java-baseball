package ui;

import java.util.Scanner;

public class InputOutputUtil {
	private final Scanner scanner;

	public InputOutputUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public void printError(String message) {
		printError();
		System.out.println(message);
	}

	public void printError() {
		System.out.println("에러입니다.");
	}
}
