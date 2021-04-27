package baseball.judge;

public class Judge {
	private String message;
	private boolean isSuccess;

	public Judge(String message, boolean isSuccess) {
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean success) {
		isSuccess = success;
	}
}
