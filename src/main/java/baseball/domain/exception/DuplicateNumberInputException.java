package baseball.domain.exception;

public class DuplicateNumberInputException extends BaseballGameException {

	private static final String ERROR_MESSAGE = "중복된 숫자가 입력될 수 없습니다.";

	public DuplicateNumberInputException() {
		super(ERROR_MESSAGE);
	}
}
