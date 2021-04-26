package service.impl;

import java.util.Map;

import dto.BallCount;
import service.IMatchingSystem;

public class MatchingSystem implements IMatchingSystem {

	private static int MAX_DIGIT_NUMBER;

	public MatchingSystem(final int maxDigitNumber) {
		MAX_DIGIT_NUMBER = maxDigitNumber;
	}

	/**
	 * 컴퓨터  숫자와 플레이어가 제시한 숫자 매칭
	 */
	@Override
	public BallCount match(final Map<Integer, Integer> computerNumber, final int[] playerNumber) {
		BallCount ballCount = new BallCount();
		for (int digitIndex = 0; digitIndex < MAX_DIGIT_NUMBER; digitIndex++) {
			computeBallCount(computerNumber, playerNumber[digitIndex], digitIndex, ballCount);
		}
		return ballCount;
	}

	/**
	 *  볼 카운트 계산
	 */
	private void computeBallCount(
		final Map<Integer, Integer> computerNumber, final int playerDigit, final int playerDigitIndex,
		final BallCount ballCount
	) {
		// 동일한 숫자가 존재하는지 체크
		final Integer computerDigitIndex = computerNumber.get(playerDigit);
		if (computerDigitIndex == null)
			return;
		// 숫자의 위치도 같은지 체크
		if (computerDigitIndex == playerDigitIndex) {
			ballCount.addStrike();
			return;
		}
		ballCount.addBall();
	}
}
