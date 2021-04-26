package baseball.game.enums;

public enum Command {

	UNKNOWN("0", "[정의되지 않은 명령]"),    //	정의되지 않은 명령
	AGAIN("1", "[다시하기]"),    //	다시하기

	EXIT("2", "[종료]");        // 게임 종료

	private final String command;    // 명령 이름
	private final String name;    // 명령 이름

	Command(String command, String name) {
		this.command = command;
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	/**
	 * 명령이 존재하는지 검증
	 *
	 * @param input trim된 문자열
	 * @return 존재하는지 여부 반환
	 */
	public static Command parse(String input) {

		String inputCommand = String.valueOf(input);
		if (AGAIN.command.equals(inputCommand)) {
			return AGAIN;
		}

		if (EXIT.command.equals(input)) {
			return EXIT;
		}

		return UNKNOWN;
	}

	/**
	 * 재시작 가능한지 판별
	 */
	public static boolean canAgain(Command cmd) {
		return AGAIN.equals(cmd);
	}

	public static boolean canExit(Command cmd) {
		return EXIT.equals(cmd);
	}

}
