package game.baseball.domain.shared;

public enum GameStatus {
	CONTINUE, END;

	public static GameStatus valueOf(boolean isWin) {
		return isWin ? GameStatus.END : GameStatus.CONTINUE;
	}
}
