package baseball.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniqueRandomNumbersGenerator implements NumbersGenerator {

	private static final List<Integer> DEFAULT_ALLOWED_NUMBERS = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	private final List<Integer> allowedNumbers;

	public UniqueRandomNumbersGenerator() {
		this.allowedNumbers = DEFAULT_ALLOWED_NUMBERS;
	}

	public UniqueRandomNumbersGenerator(List<Integer> allowedNumbers) {
		this.allowedNumbers = allowedNumbers;
	}

	@Override
	public List<Integer> getAllowedNumbers() {
		return this.allowedNumbers;
	}

	@Override
	public List<Integer> generate(int count) {
		validate(count);

		List<Integer> numbersToShuffle = new ArrayList<>(this.allowedNumbers);
		Collections.shuffle(numbersToShuffle);

		return numbersToShuffle.subList(0, count);
	}

	@Override
	public int getLimitCount() {
		return this.allowedNumbers.size();
	}

	private void validate(int count) {
		if (count < 1) {
			throw new IllegalArgumentException();
		}
		if (getLimitCount() < count) {
			throw new IllegalArgumentException();
		}
	}
}
