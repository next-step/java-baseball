package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballApplication {

	public static void main(String[] args) {
		while (!validate(getUserInput())) {
			System.out.println("only 3 digit number");
		}
		System.out.println("end");
	}

	private static String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요: ");
		return scanner.next();
	}

	public static boolean validate(String input) {
		return Pattern.matches("^[0-9]{3}$", input);
	}
}
