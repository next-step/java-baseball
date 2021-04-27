package baseball.domain;

import java.util.*;

public class Game {

	public static final int NUMBER_LENGTH = 3;

	private int[] target;

	public void start() {
		target = generateRandomNumbers();

		for (int n: target) {
			System.out.print(n);
		}
	}

	public int[] getTarget() {
		return target.clone();
	}

	private int[] generateRandomNumbers() {
		Integer[] allNumbers = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> pocket = Arrays.asList(allNumbers);
		Collections.shuffle(pocket);

		int[] numbers = new int[NUMBER_LENGTH];
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			numbers[i] = pocket.get(i);
		}
		return numbers;
	}

	private boolean countStrikeAndMark(int index, int[] targetNumbers, int[] userNumbers) {
		boolean isStrike = targetNumbers[index] == userNumbers[index];
		if(isStrike) userNumbers[index] = -1;
		return isStrike;
	}

	private void countStrike(int[] numbers, Result result) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			boolean isStrike = countStrikeAndMark(i, target, numbers);
			if(isStrike) result.strike++;
		}

		if(result.strike == NUMBER_LENGTH) {
			result.isSuccess = true;
		}
	}

	private void countBall(int[] numbers, Result result) {
		Set<Integer> remainNumbers = new HashSet();

		int len = numbers.length;
		for (int i = 0; i < len; i++) {
			if(numbers[i] != -1) remainNumbers.add(numbers[i]);
		}

		for (int i = 0; i < NUMBER_LENGTH; i++) {
			boolean isBall = remainNumbers.contains(target[i]);
			if(isBall) result.ball++;
		}
	}

	public Result judge(int[] numbers) {
		Result result = new Result();
		countStrike(numbers, result);
		countBall(numbers, result);

		return result;
	}
}
