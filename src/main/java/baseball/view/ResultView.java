package baseball.view;

public class ResultView {
	private static final String NOTHING_MESSAGE = "나싱";
	private static final String STRIKE_COUNT_MESSAGE = "%d 스트라이크 ";
	private static final String BALL_COUNT_MESSAGE = "%d 볼 ";
	private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

	public static void printNothing() {
		System.out.print(NOTHING_MESSAGE);
	}

	public static void printStrikeCount(int strikeCount) {
		System.out.print(String.format(STRIKE_COUNT_MESSAGE, strikeCount));
	}

	public static void printBallCount(int ballCount) {
		System.out.print(String.format(BALL_COUNT_MESSAGE, ballCount));
	}

	public static void printFinish() {
		System.out.println(GAME_FINISH_MESSAGE);
	}

	public static void printEndOfHint() {
		System.out.println();
	}

	private ResultView() {
	}
}
