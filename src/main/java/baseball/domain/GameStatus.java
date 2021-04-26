package baseball.domain;

public enum GameStatus {
	NEW(1, true),
	GAMEOVER(2, false);

	private int answer;
	private boolean isContinue;

	GameStatus(int answer, boolean isContinue) {
		this.answer = answer;
		this.isContinue = isContinue;
	}

	public int getAnswer() {
		return answer;
	}

	public boolean isContinue() {
		return isContinue;
	}
}
