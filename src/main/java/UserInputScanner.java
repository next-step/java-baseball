import java.util.Scanner;

import data.BaseballNumbers;
import data.GameEndStatus;
import data.GameMessage;

public class UserInputScanner {
	private Scanner scanner;

	public UserInputScanner() {
		this.scanner = new Scanner(System.in);
	}

	public BaseballNumbers getUserNumbers() {
		System.out.print(GameMessage.MESSAGE_NUMBER_INPUT_REQUEST);
		String input = this.scanner.nextLine();
		return new BaseballNumbers(input);
	}

	public GameEndStatus getEndStatus() {
		GameEndStatus status;
		do {
			System.out.println(GameMessage.MESSAGE_RETRY_OR_FINISH);
			String input = this.scanner.nextLine();
			status = getEndStatusFromString(input);
		} while (status == GameEndStatus.UNKNOWN);

		return status;
	}

	private GameEndStatus getEndStatusFromString(String str) {
		if (str.equals("1")) {
			return GameEndStatus.RETRY;
		}
		if(str.equals("2")) {
			return GameEndStatus.FINISH;
		}
		return GameEndStatus.UNKNOWN;
	}
}
