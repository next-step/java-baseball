package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


import baseball.constant.MessageContainer;
import baseball.exception.InvalidInputException;

public class BaseballNumber {
	protected static final int BALL_MAX_VALUE = 9;
	protected static final int BALL_MIN_VALUE = 1;
	private int ballCount;
	private Integer[] numbers;

	public BaseballNumber(int ballCount) {
		this.ballCount = ballCount;
		numbers = generateNumbers(ballCount);
	}

	protected BaseballNumber(Integer... numbers) {
		this.ballCount = numbers.length;
		this.numbers = numbers;
	}

	protected BaseballNumber(String input, int ballCount) {
		this.ballCount = ballCount;
		this.numbers = parseInput(input, ballCount);
	}

	protected Integer[] generateNumbers(int ballCount) {
		Integer[] numbers = new Integer[ballCount];
		Random randomGenerator = new Random();
		Set<Integer> randomNumbers = new HashSet<>();

		while (randomNumbers.size() < numbers.length) {
			int randomNumberBall = randomGenerator.nextInt(BALL_MAX_VALUE) + BALL_MIN_VALUE;
			numbers[randomNumbers.size()] = randomNumberBall;
			randomNumbers.add(randomNumberBall);
		}
		return numbers;
	}

	public List<Integer> getNumbers() {
		return Arrays.asList(numbers);
	}

	public int getBallCount() {
		return ballCount;
	}

	public Integer[] parseInput(String input, int ballCount) {
		int inputCount = input.length();
		validateBallCount(ballCount, inputCount);

		return validateTypeAndParseInput(input);
	}

	private void validateBallCount(int ballCount, int inputCount) {
		if (inputCount != ballCount) {
			throw new InvalidInputException(
				String.format(MessageContainer.INPUT_COUNT_ERROR_MESSAGE, ballCount, inputCount));
		}
	}

	private Integer[] validateTypeAndParseInput(String input) {
		String[] inputNumbers = input.split("");
		Integer[] parsedInput = new Integer[inputNumbers.length];

		for (int i = 0; i < parsedInput.length; i++) {
			parsedInput[i] = parseInt(inputNumbers[i]);
		}

		return parsedInput;
	}

	private Integer parseInt(String inputNumber) {
		try {
			return Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(String.format(MessageContainer.INPUT_TYPE_ERROR_MESSAGE));
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i : numbers) {
			sb.append(i);
		}
		return sb.toString();
	}
}
