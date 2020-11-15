package exam.baseball;

import java.util.Scanner;

public class GameLauncherScanner {

	private static final String MESSAGE_RETRY_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String MESSAGE_WRONG_FORMAT = "잘못된 형식의 입력입니다. 1 또는 2로 입력해야 합니다. ";
	private static final Scanner scanner = new Scanner(System.in);

	public static int getCodeForRetry() {
		int input = 0;
		do {
			printForScanner(MESSAGE_RETRY_OR_EXIT);
			input = scanner.nextInt();
		} while(incorrectRetryInput(input));
		return input;
	}
	
	
	
	private static boolean incorrectRetryInput(int input) {
		if(input == 1 || input == 2) {
			return false;
		}
		printForScanner(MESSAGE_WRONG_FORMAT);
		return true;
	}
	
	private static void printForScanner(String msg) {
		System.out.println(msg);
	}
}
