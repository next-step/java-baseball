package baseball.service;

import baseball.domain.BallNumber;

public class BaseballResult {

	private int strikeCount;
	private int ballCount;

	private BaseballResult(BallNumber playerBallNumber, BallNumber computerBallNumber) {
		strikeCount = 0;
		ballCount = 0;
		compareBallNumbers(playerBallNumber, computerBallNumber);
	}

	//todo: indent < 2 줄여야 합니다. refactoring 필요
	private void compareBallNumbers(BallNumber playerBallNumber, BallNumber computerBallNumber) {
		for (int playerIndex = 0; playerIndex < BallNumber.SIZE; playerIndex++) {
			for (int computerIndex = 0; computerIndex < BallNumber.SIZE; computerIndex++) {
				if (playerBallNumber.getNumberByIndex(playerIndex) == computerBallNumber.getNumberByIndex(computerIndex)
					&& playerIndex == computerIndex)
					addStrikeCount();

				if (playerBallNumber.getNumberByIndex(playerIndex) == computerBallNumber.getNumberByIndex(computerIndex)
					&& playerIndex != computerIndex)
					addBallCount();
			}
		}
	}

	private void addStrikeCount() {
		strikeCount++;
	}

	private void addBallCount() {
		ballCount++;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

}
