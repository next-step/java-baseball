package baseballgame;
드
import java.util.Scanner;

public class User {

	private String[] userStringInputArray;
	private String userInput;

	public void setUserAnswerNumberArray() {
		try {
			Scanner scanner = new Scanner(System.in);
			userInput = scanner.nextLine();
			validateInput(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public int[] getUserInputArray() {
		userStringInputArray = userInput.split("");
		int[] userInputArray = new int[userStringInputArray.length];
		for (int i = 0; i < userStringInputArray.length; i++) {
			userInputArray[i] = Integer.parseInt(userStringInputArray[i]);
		}
		return userInputArray;
	}

	public void validateInput(String userInput) {
		if (userInput.length() != 3) {
			throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
		}
		if (!userInput.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}

}
