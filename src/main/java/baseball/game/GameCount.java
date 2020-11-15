package baseball.game;

import static baseball.constants.GameConstants.*;

public class GameCount {
	private int computerIndex = 0;
	private int userIndex = 0;
	private int strikeCount = 0;
	private int ballCount = 0;

	public int getComputerIndex() {
		return computerIndex;
	}

	public void addComputerIndex() {
		++computerIndex;
	}

	public int getUserIndex() {
		return userIndex;
	}

	private void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}

	public void addUserIndex() {
		++userIndex;
	}

	public void initUserIndex() {
		setUserIndex(0);
	}

	public void overUserIndex() {
		setUserIndex(99);
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}

	public void addStrikeCount() {
		++strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void addBallCount() {
		++ballCount;
	}

	public void displayGameCount() {
		if (getStrikeCount() == 0 && getBallCount() == 0) {
			System.out.println(MESSAGE_MATCH_NOTHING);
			return;
		}
		String builder = (getStrikeCount() > 0 ? String.format(MESSAGE_MATCH_STRIKE, getStrikeCount()) : "")
			+ (getBallCount() > 0 ? String.format(MESSAGE_MATCH_BALL, getBallCount()) : "");
		System.out.println(builder);
	}

	public boolean isPassed() {
		boolean isPassed = strikeCount == MAX_COUNT_STRIKE;
		if (isPassed) {
			System.out.printf(MESSAGE_MATCH_EVERYTHING, MAX_COUNT_STRIKE);
		}
		return isPassed;
	}
}
