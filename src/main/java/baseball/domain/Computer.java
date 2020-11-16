package baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {

	private static final int BALL_SIZE = 3;

	private List<Integer> baseball;


	public Computer() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numbers);
		baseball = numbers.subList(0, BALL_SIZE);
	}

	public List<Integer> getBaseball() {
		return baseball;
	}

	public void setBaseball(List<Integer> input) {
		baseball = input;
	}
}
