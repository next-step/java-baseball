package javabaseball;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomNumberStringGenerator {

	public String generate(int length) {
		List<Integer> candidates = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		while (stringBuilder.length() < length) {
			int randomIndex = random.nextInt(candidates.size());
			int electedNumber = candidates.remove(randomIndex);
			stringBuilder.append(electedNumber);
		}

		return stringBuilder.toString();
	}
}
