package baseball.domain;

public enum BallKind {
	STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

	private final String message;

	BallKind(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
