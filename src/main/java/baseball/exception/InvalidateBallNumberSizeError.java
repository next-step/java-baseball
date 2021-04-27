package baseball.exception;

public class InvalidateBallNumberSizeError extends InvalidateBallNumberException {
	public InvalidateBallNumberSizeError(final String message) {
		super("중복되지 않은 3자리 수를 입력하세요 : " + message);
	}
}
