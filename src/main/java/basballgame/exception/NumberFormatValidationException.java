package basballgame.exception;

public class NumberFormatValidationException extends ValidationException{
	public NumberFormatValidationException() {
		super(ExceptionMessages.INVALID_NUMBER_FORMAT);
	}
}
