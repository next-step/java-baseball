package game.baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class CalculateBaseball {
	public Set<Integer> makeComputerBaseBallNumber() {
		Set<Integer> computerBaseBallNumbers = new LinkedHashSet<>();
		while (computerBaseBallNumbers.size() < 3) {
			computerBaseBallNumbers.add(getRandomNumberInRange(1, 9));
		}
		return computerBaseBallNumbers;
	}

	private int getRandomNumberInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
}
