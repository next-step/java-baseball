package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
	private final Random random;

	public RandomGenerator() {
		this.random = new Random();
	}

	public int generate() {
		List<Integer> candidates = buildCandidates();
		return generateRandomValueWithCandidates(candidates);
	}

	private List<Integer> buildCandidates() {
		List<Integer> candidates = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			candidates.add(i);
		}

		Collections.shuffle(candidates);
		return candidates.subList(0, 3);
	}

	private int generateRandomValueWithCandidates(List<Integer> candidates) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += candidates.get(i) * Math.pow(10, i);
		}

		return result;
	}
}
