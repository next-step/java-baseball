package me.right42.domain;

import me.right42.generator.BallNumbersGenerator;

public class Computer {

	private final BallNumbersGenerator ballNumberGenerator;

	public Computer(BallNumbersGenerator ballNumberGenerator) {
		this.ballNumberGenerator = ballNumberGenerator;
	}

	public BallNumbers generateBall() {
		return ballNumberGenerator.generate();
	}
}
