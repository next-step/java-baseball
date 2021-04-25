package com.nextstep.precourse.user;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
	private Scanner scanner;

	private final String MENU_START = "1";
	private final String MENU_END = "2";

	public User() {
		this.scanner = new Scanner(System.in);
	}

	public boolean selectMenu() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		String selectedMenu = "";
		boolean isValidInput = false;
		while (!isValidInput) {
			selectedMenu = scanner.next();
			isValidInput = isValidMenuSelection(selectedMenu);
		}
		return checkRestartGame(selectedMenu);
	}

	public boolean isValidMenuSelection(String selectedMenu) {
		if (selectedMenu.equals(MENU_START) || selectedMenu.equals(MENU_END)) {
			return true;
		}
		return false;
	}

	public boolean checkRestartGame(String selectedMenu) {
		if (selectedMenu.equals(MENU_START)) {
			return true;
		}
		if (selectedMenu.equals(MENU_END)) {
			return false;
		}
		System.out.println("잘못된 입력입니다. 종료합니다.");
		return false;
	}

	public String receiveAnswer() {
		System.out.print("숫자를 입력해주세요 : ");

		String answer = "";
		boolean isValidInput = false;
		while (!isValidInput) {
			answer = scanner.next();
			isValidInput = isValidAnswerInput(answer);
		}
		return answer;
	}

	public boolean isValidAnswerInput(String answer) {
		String answerPattern = "^([1-9]){3}$";
		if (!Pattern.matches(answerPattern, answer)) {
			return false;
		}
		char[] answerChars = answer.toCharArray();
		if (answerChars[0] == answerChars[1] || answerChars[0] == answerChars[2] || answerChars[1] == answerChars[2]) {
			return false;
		}
		return true;
	}
}
