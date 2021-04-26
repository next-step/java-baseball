package service.impl;

import java.util.Map;

import dto.BallCount;
import service.IMatchingSystem;

public class MatchingSystem implements IMatchingSystem {

	private static int MAX_DIGIT_NUMBER;

	public MatchingSystem(final int maxDigitNumber) {
		MAX_DIGIT_NUMBER = maxDigitNumber;
	}

	@Override
	public BallCount match(final Map<Integer, Integer> computerNumber, final int[] playerNumber) {
		BallCount ballCount = new BallCount();
		for (int digitIndex = 0; digitIndex < MAX_DIGIT_NUMBER; digitIndex++) {
			computeBallCount(computerNumber, playerNumber[digitIndex], digitIndex, ballCount);
		}
		return ballCount;
	}

	private void computeBallCount(
		final Map<Integer, Integer> computerNumber, final int playerDigit, final int playerDigitIndex,
		final BallCount ballCount
	) {
		final Integer computerDigitIndex = computerNumber.get(playerDigit);
		if (computerDigitIndex == null)
			return;
		if (computerDigitIndex == playerDigitIndex) {
			ballCount.addStrike();
			return;
		}
		ballCount.addBall();
	}
}
