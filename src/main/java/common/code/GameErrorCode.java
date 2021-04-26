package common.code;

public enum GameErrorCode {
	
	NUMBER_RANGE_ERROR("0001","Range of number is wrong."),
	NUMBER_NON_UNIQUE_ERROR("0002", "The number must be unique."),
	INPUT_INVALID_FORMAT_ERROR("0003", "Invalid input format");
	
	private String errorCode;
	private String errorMessage;
	
	private GameErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
