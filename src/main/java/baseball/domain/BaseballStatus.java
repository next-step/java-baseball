package baseball.domain;

public enum BaseballStatus {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	private final String description;

	BaseballStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
