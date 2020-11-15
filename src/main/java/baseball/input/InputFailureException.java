package baseball.input;

public class InputFailureException extends RuntimeException {

	public InputFailureException() {}

	public InputFailureException(String message) {
		super(message);
	}
}
