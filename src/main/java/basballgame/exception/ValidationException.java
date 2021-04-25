package basballgame.exception;

public class ValidationException extends RuntimeException{
	protected ValidationException(String message) {
		super(message);
	}
}
