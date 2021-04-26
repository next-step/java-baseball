package baseball.exception;

public class BadInputException extends RuntimeException {
	public BadInputException() {
		super("입력값이 부적절합니다.");
	}
}
