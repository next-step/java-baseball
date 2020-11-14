package baseball.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniqueRandomNumbersGenerator implements NumbersGenerator {

	private final List<Integer> numberPool;

	public UniqueRandomNumbersGenerator(Integer[] numbers) {
		this.numberPool = Collections.unmodifiableList(Arrays.asList(numbers));
	}

	public UniqueRandomNumbersGenerator(List<Integer> numbers) {
		this.numberPool = Collections.unmodifiableList(numbers);
	}

	@Override
	public List<Integer> getNumberPool() {
		return this.numberPool;
	}

	@Override
	public List<Integer> generate(int count) {
		validate(count);

		List<Integer> numbersToShuffle = new ArrayList<>(this.numberPool);
		Collections.shuffle(numbersToShuffle);

		return numbersToShuffle.subList(0, count);
	}

	@Override
	public int getLimitCount() {
		return this.numberPool.size();
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
