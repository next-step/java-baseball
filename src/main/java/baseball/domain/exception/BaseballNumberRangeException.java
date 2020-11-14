package baseball.domain.exception;

public class BaseballNumberRangeException extends BaseballGameException {

	private static final String ERROR_MESSAGE = "0 ~ 9 사이의 숫자여야 합니다.";

	public BaseballNumberRangeException() {
		super(ERROR_MESSAGE);
	}
}
