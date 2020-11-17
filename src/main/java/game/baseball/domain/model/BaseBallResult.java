package game.baseball.domain.model;

import game.baseball.domain.shared.BaseBallStatus;
import game.baseball.domain.shared.StringUtils;

public class BaseBallResult {
	private int strike = 0;
	private int ball = 0;

	public static BaseBallResult generateNotting() {
		return new BaseBallResult();
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public void update(BaseBallStatus baseBallStatus) {
		if (baseBallStatus == BaseBallStatus.STRIKE) {
			this.strike++;
		} else if (baseBallStatus == BaseBallStatus.BALL) {
			this.ball++;
		}
	}

	public boolean isWin() {
		return this.strike == 3;
	}

	@Override
	public String toString() {
		String message = StringUtils.join(StringUtils.BLANK, getStrikeMessage(), getBallMessage());

		if (message.trim().equals(StringUtils.EMPTY)) {
			message = BaseBallStatus.NOTTING.getText();
		}

		return message;
	}

	private String getStrikeMessage() {
		if (this.strike == 0) {
			return StringUtils.EMPTY;
		}

		return StringUtils.join(StringUtils.BLANK, String.valueOf(this.strike), BaseBallStatus.STRIKE.getText());
	}

	private String getBallMessage() {
		if (this.ball == 0) {
			return StringUtils.EMPTY;
		}

		return StringUtils.join(StringUtils.BLANK, String.valueOf(this.ball), BaseBallStatus.BALL.getText());
	}

}
