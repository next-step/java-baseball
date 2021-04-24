package me.right42.domain;

import me.right42.generator.ThreeBallGenerator;

public class Computer {

	private final ThreeBallGenerator ballNumberGenerator;

	public Computer(ThreeBallGenerator ballNumberGenerator) {
		this.ballNumberGenerator = ballNumberGenerator;
	}

	public ThreeBall generateBall() {
		return ballNumberGenerator.generate();
	}
}
