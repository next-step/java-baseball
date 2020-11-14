package edu.nextstep.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ui {
	public static Scanner scanner = new Scanner(System.in);

	public static String inputThreeNumber() {
		printMessage("숫자를 입력해주세요 : ");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[1-9][1-9][1-9]$", input)) {
			return inputThreeNumber();
		}
		return input;
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}