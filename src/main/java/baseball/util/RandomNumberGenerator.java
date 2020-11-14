package baseball.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int START_INDEX = 0;

	@Override
	public List<Integer> generate(int size) {
		List<Integer> candidateNumbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(candidateNumbers);
		return candidateNumbers.subList(START_INDEX, size);
	}
}
