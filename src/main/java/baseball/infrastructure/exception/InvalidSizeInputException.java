package baseball.infrastructure.exception;

public class InvalidSizeInputException extends InfraStructureException {

	private final static String ERROR_MESSAGE = "입력은 %d 자리의 숫자여야 합니다.";
	public InvalidSizeInputException(int size) {
		super(String.format(ERROR_MESSAGE, size));
	}
}
