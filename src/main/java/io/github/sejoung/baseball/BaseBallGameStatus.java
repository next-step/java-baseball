package io.github.sejoung.baseball;

import io.github.sejoung.baseball.constants.GameStatus;

public class BaseBallGameStatus {
	private GameStatus status;

	public GameStatus getStatus() {
		return status;
	}

	public BaseBallGameStatus() {
		this.status = GameStatus.DOING;
	}

	public void restartGame() {
		this.status = GameStatus.RESTART;
	}

	public void playGame() {
		this.status = GameStatus.DOING;
	}
}
