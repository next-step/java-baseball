/*
 * @(#) ErrorMessage.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.constants;

/**
 * @author 박준영
 **/
public enum ErrorMessage {

	NOT_INPUT_FORMAT("입력값 형식이 다릅니다."),
	NOW_ALLOWED_LENGTH("입력 가능한 길이는 세자리입니다.");

	ErrorMessage(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return this.message;
	}
}
