package ui.type;

public enum GamePlayExceptionType {
	INPUT_DATA_IS_NOT_VALID("입력된 값은 유효하지 않습니다."),
	INPUT_DATA_IS_NULL("입력된 숫자가 없습니다."),
	INPUT_DATA_DIGIT_NOT_MATCH("자릿수가 맞지 않습니다."),
	INPUT_DATA_CONTAIN_ZERO("0은 포함할 수 없습니다."),
	;

	private final String message;

	GamePlayExceptionType(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}
}
