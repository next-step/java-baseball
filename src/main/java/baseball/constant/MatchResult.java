package baseball.constant;

public enum MatchResult {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	private String resultMessage;

	MatchResult(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResultMessage() {
		return resultMessage;
	}
}
