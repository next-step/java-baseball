package game.baseball.domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import game.baseball.domain.shared.NumberUtils;

public class AnswerNumber extends BaseBallNumber {
	private static final int[] NUMBERS_FROM_ONE_TO_NINE = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	private final Map<Integer, Integer> numberIndexMap;

	AnswerNumber(List<Integer> numbers, Map<Integer, Integer> numberIndexMap) {
		super(numbers);
		this.numberIndexMap = numberIndexMap;
	}

	public static AnswerNumber generate() {
		List<Integer> numbers = createUniqueNumbers();
		return new AnswerNumber(numbers, NumberUtils.createNumberIndexMap(numbers));
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

	public Integer getIndex(int key) {
		return numberIndexMap.get(key);
	}

}
