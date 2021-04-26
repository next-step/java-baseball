package numberBaseBallGame.view;

public enum BaseBallStatus {
	STRIKE("STRIKE", "스트라이크"),
	BALL("BALL", "볼"),
	NOTHING("NOTHING", "낫싱");

	private String code;
	private String message;

	BaseBallStatus(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
