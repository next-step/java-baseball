package basballgame.exception;

public class NumberRangeValidationException extends ValidationException{
	public NumberRangeValidationException() {
		super(ExceptionMessages.INVALID_NUMBER_RANGE);
	}
}
