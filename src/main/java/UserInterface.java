import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {
	private Scanner scanner;

	public UserInterface() {
		scanner = new Scanner(System.in);
	}

	public void gameStart() {
		do {
			System.out.println("게임을 시작합니다.");

			System.out.println("게임 종료");

		} while (continueOrStop(receiveNumber()));
	}

	private boolean continueOrStop(int input) {
		return input == 1;
	}

	private int receiveNumber() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		String input = scanner.nextLine();

		if (isOneOrTwo(input)) {
			return Integer.parseInt(input);
		}

		System.out.println("1 또는 2를 입력하세요.");
		return receiveNumber();
	}

	private boolean isOneOrTwo(String input) {
		return Pattern.matches("[12]", input);
	}
}
