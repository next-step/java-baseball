package model;

public enum ExceptionMessageEnum {

	INVALID("잘못된 형식입니다. 숫자만 입력해주세요."),
	INVALID_NUMBER_RANGE("숫자는 1 ~ 9사이로 입력해주세요"),
	DUPLICATE("중복되지 않은 숫자로 SIZE 개를 입력해주세요."),
	NULL_OR_BLANK("잘못된 입력입니다. 숫자만 입력해주세요."),
	INVALID_SIZE("size is not valid");

	private String message;

	ExceptionMessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage(int size) {
		return message.replaceAll("SIZE", "" + size);
	}
}
