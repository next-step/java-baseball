package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseballNumbers {
	private List<Integer> numbers;

	public BaseballNumbers(Collection<Integer> numbers) {
		this.numbers = new ArrayList<>(numbers);
	}

	public BaseballNumbers(String str) {
		this.numbers = new ArrayList<>();
		for(char ch : str.toCharArray()) {
			numbers.add(Character.getNumericValue(ch));
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
