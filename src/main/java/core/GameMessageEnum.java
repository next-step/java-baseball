package core;

/**
 * Description : 게임 내 사용하는 상수 관련 enum class
 *
 * Created by jychoi on 2021/04/26.
 */
public enum GameMessageEnum {

	FOURBALL_MESSAGE("포볼"),
	STRIKE_MESSAGE(" 스트라이크 "),
	BALL_MESSAGE(" 볼"),
	INPUT_MESSAGE("숫자를 입력해주세요 : "),
	END_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	CONTINUE_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private final String message;

	GameMessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * Description : 현재 게임 결과 object를 기반으로 결과 string 생성 method
	 * @param ao 현재 게임 결과 object
	 * @return (String) 현재 입력에 대한 결과 str
	 */
	public static String getCurrentResultMessage(AnswerObject ao) {

		if (ao.isFourBall()) {
			return FOURBALL_MESSAGE.getMessage();
		}

		if (ao.getStrike() == 0) {
			return ao.getBall() + BALL_MESSAGE.getMessage();
		}

		if (ao.getBall() == 0) {
			return ao.getStrike() + STRIKE_MESSAGE.getMessage();
		}

		return ao.getStrike() + STRIKE_MESSAGE.getMessage() + ao.getBall() + BALL_MESSAGE.getMessage();
	}
}
