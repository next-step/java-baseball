import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import number.Numbers;

public class RandomNumbersGenerator implements NumbersGenerator {

	private final Random random;

	public RandomNumbersGenerator(Random random) {
		this.random = random;
	}

	@Override
	public Numbers generate() {
		Set<Integer> randomNumberSet = generateRandomNumberSet();
		return Numbers.of(randomNumberSet);
	}

	private Set<Integer> generateRandomNumberSet() {
		Set<Integer> randomNumberSet = new HashSet<>();
		while (isNotFilledByNumbersLength(randomNumberSet)) {
			int randomInt = random.nextInt(Numbers.UPPER_BOUND) + 1;
			randomNumberSet.add(randomInt);
		}
		return randomNumberSet;
	}

	private boolean isNotFilledByNumbersLength(Set<Integer> numbers) {
		return numbers.size() < Numbers.LENGTH;
	}
}
