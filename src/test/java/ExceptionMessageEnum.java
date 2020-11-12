public enum ExceptionMessageEnum {

	INVALID("this number is invalid"),
	NULL_OR_BLANK("this number is NULL OR Blank"),
	DUPLICATE("find duplicates in numbers"),
	INVALID_SIZE("size is not valid");

	private String message;

	ExceptionMessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
