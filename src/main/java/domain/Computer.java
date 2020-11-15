package domain;

import java.util.Random;

public class Computer extends Player {
	public Computer() {
		this.setNumber(this.generateRandomNumber());
	}

	private Integer generateRandomNumber() {
		final int maxInteger = 9;
		Random random = new Random();
		return Math.abs(random.nextInt(maxInteger - 1) + 1);
	}
}
