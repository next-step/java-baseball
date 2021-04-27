package ui;

import java.util.Scanner;

public class GameplayUI {

	private final Scanner scan = new Scanner(System.in);

	public void printStrike(int strike) {
		if (strike != 0) {
			System.out.printf("%d 스트라이크%n", strike);
		}
	}

	public void printBall(int ball) {
		if (ball != 0) {
			System.out.printf("%d 볼%n", ball);
		}
	}

	public void printNothing() {
		System.out.println("낫싱");
	}

	public void printRoundEndMessage() {
		printStrike(3);
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public String getNumberInput() {
		printInputRequest();
		String userInput = "";
		boolean isValidAnswerInput = false;
		while (!isValidAnswerInput) {
			userInput = scan.nextLine();
			isValidAnswerInput = isValidInput(userInput);
		}
		return userInput;
	}

	private boolean isValidInput(String userInput) {
		try {
			Integer.parseInt(userInput);
		} catch (NumberFormatException ex) {
			printWarning();
			printInputRequest();
			return false;
		}
		return isValidNumberFormat(userInput);
	}

	private boolean isValidNumberFormat(String userInput) {
		if (userInput.length() != 3 || userInput.contains("0") || hasSameNumber(userInput)) {
			printWarning();
			printInputRequest();
			return false;
		}
		return true;
	}

	private void printWarning() {
		System.out.println("유효하지 않은 입력입니다.");
	}

	public void printInputRequest() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	private boolean hasSameNumber(String userInput) {
		return userInput.charAt(0) == userInput.charAt(1)
			|| userInput.charAt(1) == userInput.charAt(2)
			|| userInput.charAt(2) == userInput.charAt(0);
	}
}
