package baseballgame;

public enum PrintMessageEnum {
	STRIKE("%,d 스트라이크"),
	BALL("%,d 볼"),
	NOTHING("낫싱"),
	ENTER_A_NUMBER("숫자를 입력해주세요 : "),
	GOT_RIGHT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private String message;

	PrintMessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
