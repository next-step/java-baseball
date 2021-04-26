package ui;

import gamelogic.GameRunner;

public class MenuUI {
	GameRunner game = new GameRunner();

	public boolean getMenuInput(String input) {
		if (!isValidMenuInput(input)) {
			System.out.println("유효하지 않은 입력입니다.");
			return true;
		}
		if (input.equals("2")) {
			System.out.println("게임을 종료합니다.");
			return false;
		}
		game.runNewGame();
		return true;
	}

	public boolean isValidMenuInput(String input) {
		if (input.equals("1") || input.equals("2")) {
			return true;
		}
		return false;
	}
}
