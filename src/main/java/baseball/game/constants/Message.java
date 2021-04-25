/*
 * @(#) message.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.constants;

/**
 * @author 박준영
 **/
public enum Message {
	INPUT_MESSAGE("숫자를 입력해주세요 : "),
	SUCCESS_MESSAGE("n개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	CONTINUE_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	Message(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return this.message;
	}
}
