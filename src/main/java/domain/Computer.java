package domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import vo.BaseballNumber;

public class Computer extends Player {
	public Computer() {
		this.setNumber(this.generateRandomNumber());
	}

	private Set<BaseballNumber> generateRandomNumber() {
		final int numberCount = 3;
		final int maxInteger = 9;
		int index = 0;
		final Set<BaseballNumber> numberSet = new HashSet<>(3);

		Random random = new Random();

		while (numberSet.size() < numberCount) {
			numberSet.add(new BaseballNumber(Math.abs(random.nextInt(maxInteger - 1) + 1), index++));
		}

		return numberSet;
	}
}
