package baseball;

public class InvalidOperationValueException extends RuntimeException {

	private String value;

	public InvalidOperationValueException(int value) {
		super("Invalid operation value(" + value + ")");
		this.value = String.valueOf(value);
	}

	public String getValue() {
		return this.value;
	}
}
