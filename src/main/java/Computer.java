import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
	private List<Integer> numbers = new ArrayList<>();

	public Computer() {
		initNumbers();
	}

	public void initNumbers() {
		while (numbers.size() < 3) {
			addNumber();
		}
	}

	public void initNumbersForTest(List<Integer> list) {
		this.numbers = list;
	}

	private void addNumber() {
		int number = new Random().nextInt(9) + 1;
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
	}

	public Score calculateScore(String input) {
		Score score = new Score();
		int length = input.length();
		for (int i = 0 ; i < length ; i++) {
			char c = input.charAt(i);
			int ball = Character.digit(c, 10);
			Integer sameIndexNumber = numbers.get(i);

			if (sameIndexNumber == ball) {
				score.addStrike();
				continue;
			}

			if (numbers.contains(ball)) {
				score.addBall();
			}

		}

		return score;
	}

}
