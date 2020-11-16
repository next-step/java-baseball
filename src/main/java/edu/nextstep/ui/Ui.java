package edu.nextstep.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ui {
	public static Scanner scanner = new Scanner(System.in);

	public static String inputThreeNumber() {
		printMessage("숫자를 입력해주세요 : ");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[1-9][1-9][1-9]$", input)) {
			return inputThreeNumber();
		}
		return input;
	}

	public static void printBaseballGameVictory(int numberSize) {
		printMessageLine(numberSize + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static String inputForContinue() {
		printMessageLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = scanner.nextLine();
		if (!Pattern.matches("^1|2$", input)) {
			return inputForContinue();
		}
		return input;
	}

	public static void printMessage(String message) {
		System.out.print(message);
	}

	public static void printMessageLine(String message) {
		System.out.println(message);
	}
}