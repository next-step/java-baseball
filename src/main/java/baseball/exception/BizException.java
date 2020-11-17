package baseball.exception;

public class BizException extends RuntimeException {

	private final String code;
	private final String message;

	public BizException(BizExceptionType bizExceptionType) {
		super(bizExceptionType.name());
		this.code = bizExceptionType.getCode();
		this.message = bizExceptionType.getMessage();
	}
}