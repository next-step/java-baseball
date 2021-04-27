package baseball.domain;

public enum GameStatus {
	ON(0),
	EXIT(1),
	RESTART(2);

	public int status;

	GameStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
}
