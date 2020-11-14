package baseball.view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ResultView {
	private static final String NOTHING_MESSAGE = "나싱";
	private static final String STRIKE_COUNT_MESSAGE = "%d 스트라이크 ";
	private static final String BALL_COUNT_MESSAGE = "%d 볼 ";
	private static final String GAME_FINISH_MESSAGE = "3개의숫자를모두맞히셨습니다!게임종료";


	public static void printNothing() {
		System.out.println(NOTHING_MESSAGE);
	}

	public static void printStrikeCount(int strikeCount) {
		System.out.println(String.format(STRIKE_COUNT_MESSAGE, strikeCount));
	}

	public static void printBallCount(int ballCount) {
		System.out.println(String.format(BALL_COUNT_MESSAGE, ballCount));
	}

	public static void printFinish() {
		System.out.println(GAME_FINISH_MESSAGE);
	}
}