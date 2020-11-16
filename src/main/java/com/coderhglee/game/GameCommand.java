package com.coderhglee.game;

public enum GameCommand {
	RESTART_GAME_VALUE(1),
	END_GAME_VALUE(2);

	public final int value;

	GameCommand(int value) {
		this.value = value;
	}
}
