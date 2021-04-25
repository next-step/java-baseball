package baseball.code;

public enum DisplayCode {
	BASEBALL_IN_GAME(1, "inGame"),
	BASEBALL_END_GAME(2, "endGame"),
	BASEBALL_CONTINUE_GAME(3, "continueGame");

	private int code;
	private String abbreviation;

	DisplayCode(int code, String abbreviation) {
		this.code = code;
		this.abbreviation = abbreviation;
	}

	/**
	 * parameter code 의 숫자와 일치하는 화면 코드를 리턴한다.
	 * @param code
	 * @return DisplayCode
	 */
	public static DisplayCode getDisplayCode(int code) {
		DisplayCode matchedCode = null;

		for (DisplayCode displayCode : DisplayCode.values()) {
			matchedCode = displayCode.code == code ? displayCode : matchedCode;
		}

		return matchedCode;
	}
}
