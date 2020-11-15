package baseball.domain;

public enum GameStatus {
	IN_PROGRESSING,
	END;

	public boolean isFinished() {
		return this == END;
	}
}
