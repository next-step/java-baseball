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
		System.out.println(makeResultString(result));
	}

	private String makeResultString(BaseballResult result) {
		int countStrike = result.getCountStrike();
		int countBall = result.getCountBall();
		if (countStrike == 0 && countBall == 0) {
			return MSG_NOTHING;
		}
		return makeResultStringStrike(countStrike) + makeResultStringBall(countBall);
	}

	private String makeResultStringStrike(int countStrike) {
		return countStrike > 0 ? countStrike + " " + MSG_STRIKE + " " : "";
	}

	private String makeResultStringBall(int countBall) {
		return countBall > 0 ? countBall + " " + MSG_BALL + " " : "";
	}

	public static void printGameOver() {
		System.out.println(MSG_GAME_OVER);
	}
}
