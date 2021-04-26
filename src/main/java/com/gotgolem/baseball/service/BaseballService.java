package com.gotgolem.baseball.service;

import java.util.Arrays;
import java.util.List;

import com.gotgolem.baseball.asset.number.NumberGenerator;
import com.gotgolem.baseball.asset.pitch.Ball;
import com.gotgolem.baseball.asset.pitch.ThreePitches;

public class BaseballService {

	private final NumberGenerator numberGenerator;

	public BaseballService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public ThreePitches createThreePitches() {
		final int[] ballNumbers = numberGenerator.generateThreeNumbers();
		final List<Ball> balls = Arrays.asList(
				Ball.toBall(ballNumbers[0]),
				Ball.toBall(ballNumbers[1]),
				Ball.toBall(ballNumbers[2])
		);
		return new ThreePitches(balls);
	}

}
