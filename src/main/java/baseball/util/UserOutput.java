package baseball.util;

import baseball.dao.BaseballConstant;

public class UserOutput extends BaseballConstant {

	private static final String PRINT_USER_INPUT_NUMBER = "숫자를 입력해주세요(" + BASEBALL_GAME_COUNT + "자리) : ";
	private static final String PRINT_USER_GAME_END = BASEBALL_GAME_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임종료";
	private static final String PRINT_USER_INPUT_ERROR = "잘못된 입력을 하셨습니다. 다시 입력해 주세요.";
	private static final String PRINT_TO_BE_CONTINUED =
		"게임을 새로 시작하려면 " + BASEBALL_GAME_RESTART + ", 종료하려면 " + BASEBALL_GAME_END + "를 입력하세요.";

	private static final String PRINT_STRIKE = " 스트라이크 ";
	private static final String PRINT_BALL = " 볼 ";
	private static final String PRINT_NOTHING = "낫싱";

	private static final String PRINT_NEXT_LINE = "\n";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printNextLine() {

		messagePrint(PRINT_NEXT_LINE);
	}

	public static void printBall(Integer ballCount) {

		messagePrint(ballCount + PRINT_BALL);
	}

	public static void printStrike(
		Integer strikeCount) {
		messagePrint(strikeCount + PRINT_STRIKE);
	}

	public static void printNothing() {

		messagePrint(PRINT_NOTHING);
	}

	public static void printUserInputNumber() {

		messagePrint(PRINT_USER_INPUT_NUMBER);
	}

	public void printGameEnd() {

		messagePrint(PRINT_USER_GAME_END + PRINT_NEXT_LINE);
	}

	public static void printToBeContinued() {

		messagePrint(PRINT_TO_BE_CONTINUED + PRINT_NEXT_LINE);
	}

	public static void printInputError() {

		messagePrint(PRINT_USER_INPUT_ERROR + PRINT_NEXT_LINE);
	}
}
