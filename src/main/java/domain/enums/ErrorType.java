package domain.enums;

/**
 * @author : byungkyu
 * @date : 2020/11/13
 * @description : 에러타입
 **/
public enum ErrorType {
	BASEBALL_NUMBER_OF_INVALID_ARRANGE_EXCEPTION(400, "E001", "숫자는 1부터 9까지 입력할 수 있습니다."),
	BASEBALL_NUMBER_ONLY_NUMBER_EXCEPTION(400, "E002", "숫자만 입력할 수 있습니다."),
	BASEBALL_NUMBER_MUST_THREE_EXCEPTION(400, "E003", "입력가능한 숫자는 3자리입니다."),
	BASEBALL_NUMBER_DUPLICATE_EXCEPTION(400, "E004", "중복된 숫자가 존재합니다."),
	CHOOSE_RETRY_NUMBER_EXCEPTION(400, "E005", "입력할 수 없는 문자입니다.");

	private int status;
	private String code;
	private String message;

	ErrorType(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
