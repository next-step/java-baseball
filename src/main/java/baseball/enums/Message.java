package baseball.enums;

public enum Message {
	INPUT_NUM("숫자를 입력해 주세요 : "),
	GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
	RE_GAME("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");

	String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
