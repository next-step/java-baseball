package baseball.controller;

import java.util.HashMap;
import java.util.Map;

public enum GameChoice {
	CONTINUE(1),
	QUIT(2);

	private static final Map<Integer, GameChoice> CHOICE_TO_GAME_CHOICE;
	private int choice;

	static {
		CHOICE_TO_GAME_CHOICE = new HashMap<>();
		for (GameChoice gameChoice : values()) {
			CHOICE_TO_GAME_CHOICE.put(gameChoice.choice, gameChoice);
		}
	}

	GameChoice(int choice) {
		this.choice = choice;
	}

	public static GameChoice valueOf(int userChoice) {
		return CHOICE_TO_GAME_CHOICE.get(userChoice);
	}

	public boolean isQuit() {
		return this == QUIT;
	}
}
