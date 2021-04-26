package ui;

import constant.GameRule;

import java.util.Scanner;

public class Input {
	private static Scanner scanner = new Scanner(System.in);

	public static int getClientRequest() {
		try {
			return Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException("입력은 숫자입니다.");
		}
	}

	public static String readLine() {
		return scanner.nextLine();
	}
}
