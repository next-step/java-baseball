import java.util.ArrayList;
import java.util.List;

import util.NumberExtractor;

public class Computer {
	private static final int MAX_NUMBER = 9;
	private List<Integer> numbers = new ArrayList<>();

	public Computer() {
		while (numbers.size() < 3) {
			addNumber();
		}

		System.out.println(numbers.toString());
	}

	public void initNumbersForTest(List<Integer> list) {
		this.numbers = list;
	}

	private void addNumber() {
		int number = NumberExtractor.random(MAX_NUMBER);
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
	}

	public Score calculateScore(List<Integer> items) {
		Score score = new Score();
		for (int i = 0; i < items.size(); i++) {
			score.setCounts(numbers, i, items.get(i));
		}

		return score;
	}

}
