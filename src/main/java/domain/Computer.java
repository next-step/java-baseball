package domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import vo.BaseballNumber;

public class Computer extends Player {
	public Computer() {
		super("COMPUTER");
		this.setNumber(this.generateRandomNumber());
	}

	private Set<BaseballNumber> generateRandomNumber() {
		final int numberCount = 3;
		final int maxInteger = 9;
		final Set<Integer> numberSet = new HashSet<>(numberCount);
		final Set<BaseballNumber> baseballNumberSet = new HashSet<>(numberCount);

		int index = 0;

		Random random = new Random();

		while (numberSet.size() < numberCount) {
			numberSet.add(Math.abs(random.nextInt(maxInteger - 1) + 1));
		}

		for (Integer number : numberSet) {
			baseballNumberSet.add(new BaseballNumber(number, index++));
		}

		return baseballNumberSet;
	}
}
