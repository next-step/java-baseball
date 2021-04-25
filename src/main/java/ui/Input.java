package ui;

import java.util.Scanner;

public class Input {
	private static Scanner scanner = new Scanner(System.in);

	public static int getClientRequest() {
		try {
			return Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			Output.showMessage("숫자만 입력하세요.");
			return getClientRequest();
		}
	}

	public static String readLine() {
		return scanner.nextLine();
	}
}
