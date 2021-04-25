/*
 * @(#) NotAllowedLengthException.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.exception;

import baseball.game.constants.ErrorMessage;

/**
 * @author 박준영
 **/
public class NotAllowedLengthException extends RuntimeException {
	private static final long serialVersionUID = 8195426325346237896L;

	public NotAllowedLengthException() {
		super(ErrorMessage.NOW_ALLOWED_LENGTH.getMessage());
	}
}
