package kr.aterilio.nextstep.techcamp.baseball.ui;

import kr.aterilio.nextstep.techcamp.baseball.BaseballGame;
import kr.aterilio.nextstep.techcamp.baseball.BaseballResult;

public class ResultView {

	private static final String MSG_NOTHING = "낫싱";
	private static final String MSG_BALL = "볼";
	private static final String MSG_STRIKE = "스트라이크";
	private static final String MSG_GAME_OVER = BaseballGame.GAME_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료.";

	public void printResult(BaseballResult result) {
		if (result.isFailed()) {
			return;
		}
		System.out.println(resultToString(result));
	}

	private String resultToString(BaseballResult result) {

		int countStrike = result.getCountStrike();
		int countBall = result.getCountBall();

		StringBuilder sb = new StringBuilder();

		if (countStrike == 0 && countBall == 0) {
			return MSG_NOTHING;
		}
		if (countStrike > 0) {
			sb.append(countStrike).append(" ").append(MSG_STRIKE).append(" ");
		}
		if (countBall > 0) {
			sb.append(countBall).append(" ").append(MSG_BALL).append(" ");
		}
		return sb.toString();
	}

	public static void printGameOver() {
		System.out.println(MSG_GAME_OVER);
	}
}
