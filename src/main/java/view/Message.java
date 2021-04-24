package view;

public enum Message{
	REQUEST_INPUT("숫자를 입력해주세요 : "),
	NOTICE_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
	ASK_NEXT_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),

	NOTICE_ERROR_NULL("빈값입니다. 숫자를 입력해주세요 : "),
	NOTICE_ERROR_SIZE("반드시 세 자리 숫자를 입력해주세요 : "),
	NOTICE_ERROR_INVALID_VALUE("유효하지 않은 값이 포함되어 있습니다. 1부터 9사이의 숫자만을 입력해주세요 : "),
	NOTICE_ERROR_INVALID_STATUS_CODE("1과 2중에서만 입력해주세요 : "),

	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫씽");

	private String text;

	Message(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
