import java.util.Scanner;

import service.BaseballService;

public class BaseballMain {

	private static final String NUMBER_INPUT_QUESTION = "숫자를 입력해주세요 : ";

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		playBaseball();
	}

	private static void playBaseball() {
		BaseballService baseballService = new BaseballService();
		do {
			System.out.print(NUMBER_INPUT_QUESTION);
		} while (!baseballService.playUntilEnd(scanner.next()));
	}
}
