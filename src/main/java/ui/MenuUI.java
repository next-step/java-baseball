package ui;

import gamelogic.GameRunner;

public class MenuUI {
	GameRunner gameRunner = new GameRunner();

	public boolean getMenuInput(String input) {
		if (input.equals("1")) {
			gameRunner.runNewGame();
			return true;
		}
		if (input.equals("2")) {
			System.out.println("게임을 종료합니다.");
			return false;
		}
		System.out.println("유효하지 않은 입력입니다.");
		return true;
	}

	public void printStartMessage() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
