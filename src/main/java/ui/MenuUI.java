package ui;

import java.util.Scanner;

import gamelogic.GameRunner;

public class MenuUI {

	private final Scanner scan = new Scanner(System.in);
	private final GameRunner gameRunner = new GameRunner();

	private boolean getMenuInput(String input) {
		if (input.equals("1")) {
			gameRunner.runNewRound();
			return true;
		}
		if (input.equals("2")) {
			return false;
		}
		System.out.println("유효하지 않은 입력입니다.");
		return true;
	}

	private void printStartMessage() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private void printEndMessage() {
		System.out.println("게임을 종료합니다.");
	}

	public void startBaseballProgram() {
		boolean continueRunning = true;
		while (continueRunning) {
			printStartMessage();
			continueRunning = getMenuInput(scan.nextLine());
		}
		printEndMessage();
	}
}
