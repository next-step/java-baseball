package domain.game;

import domain.target.Balls;

public class Game {
	private Balls target;
	private boolean isCleared;

	public Game() {
		this.target = Balls.createNewTargetBalls();
		this.isCleared = false;
	}

	Turn playTurn(Balls input) {
		return new Turn(input, target);
	}

	public boolean isCleared() {
		return isCleared;
	}

	public void clear() {
		isCleared = true;
	}

}
