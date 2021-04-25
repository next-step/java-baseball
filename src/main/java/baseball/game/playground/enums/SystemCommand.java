package baseball.game.playground.enums;

public enum SystemCommand {

	AGAIN("again"),    //	다시하기

	EXIT("exit");        // 게임 종료

	private final String name;    // 명령 이름

	SystemCommand(String name) {
		this.name = name;
	}

	/**
	 * 명령이 존재하는지 검증
	 * @param input trim된 문자열
	 * @return 존재하는지 여부 반환
	 */
	public static boolean contains(String input) {

		if (AGAIN.name.equals(input)) {
			return true;
		}

		return EXIT.name.equals(input);

	}

	/**
	 * 재시작 가능한지 판별
	 * @param input trim된 문자열
	 * @return 재시작 여부 반환
	 */
	public static boolean canAgain(String input) {
		return AGAIN.name.equals(input);
	}

}
