package game.baseball.domain.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberUtils {
	public static int combine(List<Integer> numbers) {
		int totalNumber = 0;

		for (Integer number : numbers) {
			totalNumber = totalNumber * 10 + number;
		}

		return totalNumber;
	}

	public static List<Integer> split(int number) {
		List<Integer> numbers = new ArrayList<>();

		while (number != 0) {
			numbers.add(0, number % 10);
			number /= 10;
		}

		return numbers;
	}

	public static Map<Integer, Integer> createNumberIndexMap(List<Integer> uniqueNumbers) {
		Map<Integer, Integer> numberIndexMap = new HashMap<>();

		for (int i = 0; i < uniqueNumbers.size(); i++) {
			numberIndexMap.putIfAbsent(uniqueNumbers.get(i), i);
		}

		validateUniqueNumbers(uniqueNumbers.size(), numberIndexMap.size());

		return numberIndexMap;
	}

	public static void validateUniqueNumbers(int numbersSize, int numberIndexMapSize) {
		if (numbersSize != numberIndexMapSize) {
			throw new IllegalArgumentException(Message.REQUIRE_DIFFERENT_NUMBER);
		}
	}
}
