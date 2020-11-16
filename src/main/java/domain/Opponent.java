package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import domain.baseballRule.BaseballNumbers;

public class Opponent {
	private BaseballNumbers baseballNumbers;

	public Opponent() {
	}

	public BaseballNumbers generateBaseballNumbers() {
		this.baseballNumbers = BaseballNumbers.newOpponentBaseballNumbers(this.newUnique3RandomNumbers());
		return this.baseballNumbers;
	}

	private List<Integer> newUnique3RandomNumbers() {
		List<Integer> numberBoundary = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		List<Integer> randomNumbers = new ArrayList<>();
		Random random = new Random();
		for (int scope = 8; scope > 5; scope--) {
			int index = random.nextInt(scope);
			randomNumbers.add(numberBoundary.get(index));
			numberBoundary.remove(index);
		}
		return randomNumbers;
	}
}

