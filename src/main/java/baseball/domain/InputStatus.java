package baseball.domain;

/**
 * @author forrest-k
 */
public enum InputStatus {
	INVALIDATE("1~9 사이의 서로다른 3자리 숫자로 입력 해 주세요.")
	, STRIKE("스트라이크")
	, BALL("볼")
	, NOTHING("낫싱");

	private String status;

	InputStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
