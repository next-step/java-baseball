package baseball.exception;

public class InvalidateBallNumberValueError extends InvalidateBallNumberException {
	public InvalidateBallNumberValueError(final String message) {
		super("1과 9사이의 값을 넣어주세요 : " + message);
	}
}