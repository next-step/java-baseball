package game.baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Hitter {

	private Set<Integer> hittingNumbers = new LinkedHashSet<>();

	public Set<Integer> makeHittingNumbers() {
		while (hittingNumbers.size() < 3) {
			hittingNumbers.add(getRandomNumberInRange(1, 9));
		}
		return hittingNumbers;
	}

	private int getRandomNumberInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	public Set<Integer> getHittingNumbers() {
		return this.hittingNumbers;
	}

	public void setHittingNumbers(Set<Integer> hittingNumbers) {
		this.hittingNumbers = hittingNumbers;
	}
}
