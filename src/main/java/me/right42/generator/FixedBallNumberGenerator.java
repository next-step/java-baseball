package me.right42.generator;

import me.right42.domain.BallNumbers;

public class FixedBallNumberGenerator implements BallNumbersGenerator{

	private final String ballNumbers;

	public FixedBallNumberGenerator(String ballNumbers) {
		this.ballNumbers = ballNumbers;
	}

	@Override
	public BallNumbers generate() {
		return BallNumbers.create(ballNumbers);
	}
}
