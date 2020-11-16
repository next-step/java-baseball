package game.baseball.domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerNumber extends BaseBallNumber {
	private static final int[] NUMBERS_FROM_ONE_TO_NINE = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	private AnswerNumber(List<Integer> numbers) {
		super(numbers);
	}

	public static AnswerNumber generate() {
		return new AnswerNumber(createUniqueNumbers());
	}

	private static List<Integer> createUniqueNumbers() {
		Set<Integer> uniqueNumbers = new HashSet<>();

		while (uniqueNumbers.size() != BaseBallNumber.NUMBERS_SIZE) {
			uniqueNumbers.add(NUMBERS_FROM_ONE_TO_NINE[getRandomIndex()]);
		}

		return new ArrayList<>(uniqueNumbers);
	}

	private static int getRandomIndex() {
		return (int)(Math.random() * NUMBERS_FROM_ONE_TO_NINE.length);
	}
}
