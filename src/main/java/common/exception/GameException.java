package common.exception;

import common.code.GameErrorCode;


/**
 * @brief
 * Game 공통 RuntimeException
 * @details Game에서 공통으로 사용할 RuntimeException을 서술합니다.
 * @author SUNJU
 * @since 2021. 4. 27.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 27.     SUNJU         최초 생성
 * </pre>

 */
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

	public GameErrorCode getGameErrorCode() {
		return gameErrorCode;
	}
	
}
