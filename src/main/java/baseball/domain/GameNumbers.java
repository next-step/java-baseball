package baseball.domain;

import java.util.Iterator;
import java.util.List;

public class GameNumbers implements Iterable<Integer> {
	private List<Integer> numbers;

	public GameNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public boolean equals(GameNumbers input) {
		return numbers.equals(input.numbers);
	}

	public int countStrike(GameNumbers input) {
		int count = 0;

		for (int i = 0, size = numbers.size(); i < size; i++) {
			count += compareNumbers(numbers.get(i), input.numbers.get(i));
		}

		return count;
	}

	private int compareNumbers(Integer integer, Integer integer1) {
		if (integer.equals(integer1)) {
			return 1;
		}
		return 0;
	}

	public int countBall(GameNumbers input) {
		int count = 0;
		for (Integer inputNumber : input.numbers) {
			count += countIfContainsNumber(inputNumber);
		}
		return count;
	}

	private int countIfContainsNumber(Integer inputNumber) {
		if (numbers.contains(inputNumber)) {
			return 1;
		}
		return 0;
	}

	@Override
	public Iterator<Integer> iterator() {
		return numbers.iterator();
	}
}
