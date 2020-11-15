package baseball.presenter;

import baseball.game.GameScore;

public class DefaultGameScoreMessageGenerator implements GameScoreMessageGenerator {

	public static final String NOTHING = "낫싱";
	public static final String STRIKE = "스트라이크";
	public static final String BALL = "볼";

	@Override
	public String getScoreMessage(GameScore score) {
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

	private String getStrike(int strike) {
		return strike + " " + STRIKE;
	}

	private String getBall(int ball) {
		return ball + " " + BALL;
	}

	private String getStrikeAndBall(int strike, int ball) {
		return getStrike(strike) + " " + getBall(ball);
	}
}
