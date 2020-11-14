package baseball.view;

import baseball.game.GameScore;

public class GameScoreMessageGenerator {

	public static final String NOTHING = "낫싱";
	public static final String STRIKE = "스트라이크";
	public static final String BALL = "볼";

	public static String getResultMessage(GameScore score) {
		if (score.hasStrike() && score.hasBall()) {
			return getStrikeAndBall(score.getStrike(), score.getBall());
		}
		if (score.hasStrike()) {
			return getStrike(score.getStrike());
		}
		if (score.hasBall()) {
			return getBall(score.getBall());
		}
		return NOTHING;
	}

	private static String getStrike(int strike) {
		return strike + " " + STRIKE;
	}

	private static String getBall(int ball) {
		return ball + " " + BALL;
	}

	private static String getStrikeAndBall(int strike, int ball) {
		return getStrike(strike) + " " + getBall(ball);
	}
}
