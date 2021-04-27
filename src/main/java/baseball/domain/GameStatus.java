package baseball.domain;

/**
 * @author forrest-k
 */
public enum GameStatus {

	START("시작")
	, END("종료")
	, RESTART("재시작")
	, KEEP_GOING("");

	private String status;

	GameStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
