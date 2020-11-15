package baseball.domain.exception;

public class ResultLengthException extends BaseballGameException {

	private static final String ERROR_MESSAGE = "결과의 개수가 너무 많습니다.";

	public ResultLengthException() {
		super(ERROR_MESSAGE);
	}
}
