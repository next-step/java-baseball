package baseball.domain;

public enum HintType {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	private String message;

	HintType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
