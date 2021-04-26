package common.exception;

import common.code.GameErrorCode;

public class GameException extends RuntimeException{
	private static final long serialVersionUID = -1299298583412901630L;
	
	private final GameErrorCode gameErrorCode;
	
	public GameException(GameErrorCode gameErrorCode) {
		super();
		this.gameErrorCode = gameErrorCode;
	}

	public GameException(GameErrorCode gameErrorCode, String message, Throwable cause) {
		super(message, cause);
		this.gameErrorCode = gameErrorCode;
	}

	public GameException(GameErrorCode gameErrorCode, String message) {
		super(message);
		this.gameErrorCode = gameErrorCode;
	}

	public GameException(GameErrorCode gameErrorCode, Throwable cause) {
		super(cause);
		this.gameErrorCode = gameErrorCode;
	}

}
