package baseball.service;

import baseball.error.DuplicateCharactersException;
import baseball.error.NonNumericCharactersException;

import java.util.*;

;

public class GameService {

	private final int NUMBER_LENGTH = 3;
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 9;

	public Set<Integer> generateNumber() {
		Random random = new Random();
		Set<Integer> numbers = new LinkedHashSet<>();
		do {
			numbers.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
		} while (numbers.size() < NUMBER_LENGTH);
		return numbers;
	}

	public Set<Integer> parseNumbers(String input) {
		validateNumericCharacters(input);
		validateNonDuplicateCharacters(input);
		return convertNumericStringToIntegerSet(input);
	}

	private void validateNumericCharacters(String input) {
		if (!input.matches(String.format("^[%d-%d]{%d}$", MIN_NUMBER, MAX_NUMBER, NUMBER_LENGTH))) {
			throw new NonNumericCharactersException();
		}
	}

	private void validateNonDuplicateCharacters(String input) {
		if (input.length() != new HashSet<>(Arrays.asList(input.split(""))).size()) {
			throw new DuplicateCharactersException();
		}
	}

	private Set<Integer> convertNumericStringToIntegerSet(String input) {
		Set<Integer> numbers = new LinkedHashSet<>();
		for (String s : input.split("")) {
			numbers.add(Integer.parseInt(s));
		}
		return numbers;
	}

}
