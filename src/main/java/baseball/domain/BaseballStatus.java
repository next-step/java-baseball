package baseball.domain;

public enum BaseballStatus {
	STRIKE("%d 스트라이크 "),
	BALL("%d 볼"),
	NOTHING("낫싱");

	private final String messageFormat;

	BaseballStatus(String messageFormat) {
		this.messageFormat = messageFormat;
	}

	public String getMessageFormat() {
		return messageFormat;
	}
}
