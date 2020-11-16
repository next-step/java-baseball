package baseball.util;

import baseball.domain.BaseballGoalNumber;

public class UserOutput {

	private static final String PRINT_USER_INPUT_NUMBER = "숫자를 입력해주세요 : ";
	private static final String PRINT_TO_BE_CONTINUED = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String PRINT_USER_GAME_END = BaseballGoalNumber.BASEBALL_GAME_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임종료";
	private static final String PRINT_USER_INPUT_ERROR = "잘못된 입력을 하셨습니다. 다시 입력해 주세요.";

	private static final String PRINT_STRIKE = " 스트라이크 ";
	private static final String PRINT_BALL = " 볼 ";
	private static final String PRINT_NOTHING = "낫싱";

	private static final String PRINT_NEXT_LINE = "\n";

	private void messagePrint(final String message) {

		System.out.print(message);
	}

	public void printNextLine() {

		messagePrint(PRINT_NEXT_LINE);
	}

	public void printBall(Integer ballCount) {
		messagePrint(ballCount + PRINT_BALL);
	}

	public void printStrike(
		Integer strikeCount) {
		messagePrint(strikeCount + PRINT_STRIKE);
	}

	public void printNothing() {

		messagePrint(PRINT_NOTHING);
	}

	public void printUserInputNumber() {

		messagePrint(PRINT_USER_INPUT_NUMBER);
	}

	public void printToBeContinued() {
		messagePrint(PRINT_TO_BE_CONTINUED + PRINT_NEXT_LINE);
	}

	public void printGameEnd() {

		messagePrint(PRINT_USER_GAME_END + PRINT_NEXT_LINE);
	}

	public void printInputError() {

		messagePrint(PRINT_USER_INPUT_ERROR + PRINT_NEXT_LINE);
	}
}
