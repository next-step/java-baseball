package gamemaster;

public enum GameProgress {
	INVALID(0),
	GAME_CONTINUE(1),
	GAME_STOP(2);

	private final int answer;

	GameProgress(int answer) {
		this.answer = answer;
	}

	public static GameProgress findByPlayerAnswer(int answer) {
		for (GameProgress eachGameProgress : values()) {
			if (eachGameProgress.answer == answer) {
				return eachGameProgress;
			}
		}

		return GameProgress.INVALID;
	}

	public boolean isGameStop() {
		return this == GAME_STOP;
	}

	public boolean isInvalid() {
		return this == INVALID;
	}
}
