package com.pointware.game.constant;

public enum GameState {
	PLAY(1),
	EXIT(2);
	private int code;

	GameState(int code) {
		this.code = code;
	}

	public static GameState from(int code) {
		if (code == 1) {
			return PLAY;
		}
		return EXIT;
	}
}
