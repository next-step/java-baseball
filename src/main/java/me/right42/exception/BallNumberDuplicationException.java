package me.right42.exception;

public class BallNumberDuplicationException extends RuntimeException {
	public BallNumberDuplicationException() {
		super();
	}

	public BallNumberDuplicationException(String message) {
		super(message);
	}

	public BallNumberDuplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public BallNumberDuplicationException(Throwable cause) {
		super(cause);
	}

	protected BallNumberDuplicationException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
