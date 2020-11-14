package baseball.domain.exception;

public class BaseballGameException extends RuntimeException {
	BaseballGameException(final String message) {
		super(message);
	}
}
