package ui;

import java.util.Scanner;

public class GameplayUI {

	Scanner scan = new Scanner(System.in);

	public void printStrike(int strike) {
		if (strike != 0) {
			String message = String.format("%d 스트라이크 ", strike);
			System.out.println(message);
		}
	}

	public void printBall(int ball) {
		if (ball != 0) {
			String message = String.format("%d 볼", ball);
			System.out.println(message);
		}
	}

	public void printNothing() {
		System.out.println("낫싱");
	}

	public void printAnswer() {
		System.out.println("3 스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public String getAnswerInput() {
		printInputRequest();
		String userInput = "";
		boolean isValidAnswerInput = false;
		while (!isValidAnswerInput) {
			userInput = scan.nextLine();
			isValidAnswerInput = checkValidInput(userInput);
		}
		return userInput;
	}

	private boolean checkValidInput(String userInput) {
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
