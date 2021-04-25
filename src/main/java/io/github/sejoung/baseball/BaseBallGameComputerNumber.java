package io.github.sejoung.baseball;

import java.util.List;

public class BaseBallGameComputerNumber {
	private List<Integer> computerNumbers;
	private final BaseBallNumberGenerator generator;

	public BaseBallGameComputerNumber(BaseBallNumberGenerator generator) {
		this.generator = generator;
		this.computerNumbers = generator.generateBaseBallNumbers();
	}

	public void changeBaseBallGameComputerNumber() {
		this.computerNumbers = generator.generateBaseBallNumbers();
	}

	public List<Integer> getComputerNumbers() {
		return computerNumbers;
	}
}
