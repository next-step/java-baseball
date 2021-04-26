package com.gotgolem.baseball.service;

import java.util.Arrays;
import java.util.List;

import com.gotgolem.baseball.asset.number.NumberGenerator;
import com.gotgolem.baseball.asset.pitch.Ball;
import com.gotgolem.baseball.asset.pitch.PitchHint;
import com.gotgolem.baseball.asset.pitch.ThreePitches;

public class BaseballService {

	private final NumberGenerator numberGenerator;

	public BaseballService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public ThreePitches createThreePitches() {
		final int[] ballNumbers = numberGenerator.generateThreeNumbers();
		return createThreePitches(ballNumbers);
	}

	public ThreePitches createThreePitches(int[] ballNumbers) {
		if (ballNumbers.length != 3) {
			throw new IllegalArgumentException();
		}
		final List<Ball> balls = Arrays.asList(
				Ball.toBall(ballNumbers[0]),
				Ball.toBall(ballNumbers[1]),
				Ball.toBall(ballNumbers[2])
		);
		return new ThreePitches(balls);
	}

	public PitchHint getPitchHint(ThreePitches target, ThreePitches comparison) {
		final int containsBallCount = getContainsBallCount(target, comparison);
		final int strikeCount = getEqualsBallCount(target, comparison);
		final int ballCount = containsBallCount - strikeCount;
		return new PitchHint(strikeCount, ballCount);
	}

	private int getContainsBallCount(ThreePitches target, ThreePitches comparison) {
		int count = 0;
		count += target.contains(comparison.getFirst()) ? 1 : 0;
		count += target.contains(comparison.getSecond()) ? 1 : 0;
		count += target.contains(comparison.getThird()) ? 1 : 0;
		return count;
	}

	private int getEqualsBallCount(ThreePitches target, ThreePitches comparison) {
		int count = 0;
		count += target.getFirst() == comparison.getFirst() ? 1 : 0;
		count += target.getSecond() == comparison.getSecond() ? 1 : 0;
		count += target.getThird() == comparison.getThird() ? 1 : 0;
		return count;
	}

}
