package constants;

public enum Result {
	THREE_STRIKE("3 스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	CONTINUE("0 스트라이크 0 볼"),
	NOTING("낫싱");

	private String message;

	Result(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		if (this == CONTINUE) {
			this.message = message;
		}
	}
}
