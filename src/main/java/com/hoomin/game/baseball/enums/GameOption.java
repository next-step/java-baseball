package com.hoomin.game.baseball.enums;

public enum GameOption {
	RESTART(true), QUIT(false);

	private final boolean isOnGoing;

	GameOption(boolean isOnGoing) {
		this.isOnGoing = isOnGoing;
	}

	public boolean isOnGoing() {
		return isOnGoing;
	}
}
