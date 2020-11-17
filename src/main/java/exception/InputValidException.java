package exception;

public class InputValidException extends Exception {
	public InputValidException(String message) {
		super(message);
		System.out.println(message);

	}
}
