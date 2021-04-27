package constants;

public enum Messages {
	CHECK_INPUT_NUMBER("중복되지 않은 " + PlayRules.BALL_LENGTH.value() + "자리 숫자를 입력해주세요.");

	private String msg;

	Messages(String msg) {
		this.msg = msg;
	}

	public String value() {
		return msg;
	}
}
