package baseball.core;

public enum GameStatus {
	BOLL("볼"),
	STRIKE("스트라이크"),
	NONE("낫싱");

	private final String name;

	GameStatus(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

