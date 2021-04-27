package baseball.domain;

import java.util.List;

public class Player {

	private int ballCount;
	private int strikeCount;

	public Player() {
		init();
	}

	public void init() {
		this.ballCount = 0;
		this.strikeCount = 0;
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public boolean isFinished() {
		if (this.strikeCount == Game.NUMBER_LENGTH) {
			return true;
		}
		return false;
	}

}
