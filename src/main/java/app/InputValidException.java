package app;

public class InputValidException extends Exception {
	InputValidException(String message) {
		super(message);
		System.out.println(message);
	}
}
