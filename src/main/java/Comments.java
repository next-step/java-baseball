public enum Comments {
	INPUT_NUMBER("숫자를 입력해주세요 : "),
	THREE_DIGIT_ERROR("3자리 숫자를 입력해주세요"),
	DECISION("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	EXIT_RESTART_ERROR("1 또는 2를 입력해주세요");

	private String comment;

	Comments(String comment) {
		this.comment = comment;
	}
}
