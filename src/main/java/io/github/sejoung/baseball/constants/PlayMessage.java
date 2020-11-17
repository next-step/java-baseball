package io.github.sejoung.baseball.constants;

public enum PlayMessage {

	STRIKE("%d 스트라이크"), BALL("%d 볼"), NOTHING("낫싱");

	private final String message;

	PlayMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
