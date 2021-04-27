package dto;

public class GameResult {
	private final String msg;
	private final boolean successFlag;

	public GameResult(String msg, boolean successFlag) {
		this.msg = msg;
		this.successFlag = successFlag;
	}

	public String getMsg() {
		return this.msg;
	}

	public boolean getSuccessFlag() {
		return this.successFlag;
	}
}
