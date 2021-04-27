package baseball.service;

import baseball.config.AppConfig;
import baseball.domain.BallCount;
import baseball.error.DuplicateCharactersException;
import baseball.error.NonNumericCharactersException;

import java.util.*;

public class BallCountService {
	private final int RANDOM_NUMBER_LENGTH;
	private final int MAX_RANDOM_NUMBER;
	private final int MIN_RANDOM_NUMBER;

	public BallCountService(AppConfig appConfig) {
		this.RANDOM_NUMBER_LENGTH = appConfig.getRandomNumberLength();
		this.MAX_RANDOM_NUMBER = appConfig.getMaxRandomNumber();
		this.MIN_RANDOM_NUMBER = appConfig.getMinRandomNumber();
	}

	public List<Integer> generateNumbers() {
		Random random = new Random();
		Set<Integer> numbers = new LinkedHashSet<>();
		do {
			numbers.add(random.nextInt(MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER);
		} while (numbers.size() < RANDOM_NUMBER_LENGTH);
		return new ArrayList<>(numbers);
	}

	public List<Integer> parseNumbers(String input) {
		validateNumericCharacters(input);
		validateNonDuplicateCharacters(input);
		return convertNumericStringToIntegerList(input);
	}

	public BallCount compareNumbers(List<Integer> generateNumbers, List<Integer> parseNumbers) {
		int strike = getStrike(generateNumbers, parseNumbers);
		int ball = getBall(generateNumbers, parseNumbers);
		return new BallCount(strike, ball);
	}

	private void validateNumericCharacters(String input) {
		if (!input.matches(String.format("^[%d-%d]{%d}$", MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, RANDOM_NUMBER_LENGTH))) {
			throw new NonNumericCharactersException();
		}
	}

	private void validateNonDuplicateCharacters(String input) {
		if (input.length() != new HashSet<>(Arrays.asList(input.split(""))).size()) {
			throw new DuplicateCharactersException();
		}
	}

	private List<Integer> convertNumericStringToIntegerList(String input) {
		Set<Integer> numbers = new LinkedHashSet<>();
		for (String s : input.split("")) {
			numbers.add(Integer.parseInt(s));
		}
		return new ArrayList<>(numbers);
	}

	private int getStrike(List<Integer> generateNumbers, List<Integer> parseNumbers) {
		int strike = 0;
		for (int i = 0, max = generateNumbers.size(); i < max; i++) {
			int generateNumber = generateNumbers.get(i);
			int parseNumber = parseNumbers.get(i);
			strike += generateNumber == parseNumber ? 1 : 0;
		}
		return strike;
	}

	private int getBall(List<Integer> generateNumbers, List<Integer> parseNumbers) {
		int ball = 0;
		for (int i = 0, max = generateNumbers.size(); i < max; i++) {
			int generateNumber = generateNumbers.get(i);
			int parseNumber = parseNumbers.get(i);
			boolean contains = parseNumbers.contains(generateNumber);
			ball += contains && generateNumber != parseNumber ? 1 : 0;
		}
		return ball;
	}
}
