package baseball;

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

	@Override
	public Iterator<Integer> iterator() {
		return numbers.iterator();
	}
}
