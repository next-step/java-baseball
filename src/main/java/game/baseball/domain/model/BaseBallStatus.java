package game.baseball.domain.model;

public enum BaseBallStatus {
	STRIKE("스트라이크"), BALL("볼"), NOTTING("낫싱");

	private final String text;

	BaseBallStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
