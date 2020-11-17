package game.baseball.domain.shared;

public enum GameStatus {
	CONTINUE(true), END(false);

	private final boolean isContinue;

	GameStatus(boolean isContinue) {
		this.isContinue = isContinue;
	}

	public boolean isContinue() {
		return isContinue;
	}
}
