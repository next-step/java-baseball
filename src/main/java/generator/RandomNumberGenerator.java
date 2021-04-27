package generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

	public final int LENGTH = 3;

	public List<Integer> getTargetNumber() {
		Set<Integer> numberSet = new HashSet<>();
		Random random = new Random();

		while (numberSet.size() < LENGTH) {
			numberSet.add(random.nextInt(8) + 1);
		}
		return new ArrayList<>(numberSet);
	}
}
