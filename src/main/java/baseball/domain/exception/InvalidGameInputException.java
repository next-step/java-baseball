package baseball.domain.exception;

public class InvalidGameInputException extends IllegalArgumentException {
	public InvalidGameInputException(String message) {
		super(message);
	}
}
