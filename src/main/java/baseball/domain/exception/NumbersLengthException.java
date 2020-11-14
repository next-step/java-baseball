package baseball.domain.exception;

public class NumbersLengthException extends BaseballGameException {

	private static final String ERROR_MESSAGE = "%d 자리수 숫자로만 생성할 수 있습니다.";

	public NumbersLengthException(int size) {
		super(String.format(ERROR_MESSAGE, size));
	}
}
