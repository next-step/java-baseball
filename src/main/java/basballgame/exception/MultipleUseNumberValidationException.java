package basballgame.exception;

public class MultipleUseNumberValidationException extends ValidationException{
	public MultipleUseNumberValidationException() {
		super(ExceptionMessages.INVALID_MULTIPLE_USE_NUMBER);
	}
}
