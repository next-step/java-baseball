package number;

public class IllegalNumberException extends RuntimeException {

	private static final String LENGTH_OF_NUMBERS_MESSAGE = "유효하지 않은 자리수 입니다.";
	private static final String RANGE_OF_NUMBER_MESSAGE = "유효하지 않은 숫자 입니다.";
	private static final String DUPLICATION_OF_NUMBERS_MESSAGE = "서로 다른 숫자여야 합니다.";

	static final IllegalNumberException ILLEGAL_LENGTH_OF_NUMBERS = new IllegalNumberException(
		LENGTH_OF_NUMBERS_MESSAGE);
	static final IllegalNumberException ILLEGAL_RANGE_OF_NUMBER = new IllegalNumberException(
		RANGE_OF_NUMBER_MESSAGE);
	static final IllegalNumberException DUPLICATION_OF_NUMBERS = new IllegalNumberException(
		DUPLICATION_OF_NUMBERS_MESSAGE);

	private IllegalNumberException(String message) {
		super(message);
	}
}
