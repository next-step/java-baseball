package exception;

public class BaseballGameException extends RuntimeException {
	public BaseballGameException(String message) {
		super(message);
	}
	public BaseballGameException(Exception exception) {
		super(exception);
	}
}
