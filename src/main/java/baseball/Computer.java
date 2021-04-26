package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Computer {
	private static final List<Integer> CANDIDATES = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	private int numberLength;

	Computer(int numberLength) {
		this.numberLength = numberLength;
	}

	int[] chooseNumbers() {
		Collections.shuffle(CANDIDATES);

		int[] numbers = new int[numberLength];
		for (int i = 0; i < numberLength; i++) {
			numbers[i] = CANDIDATES.get(i);
		}

		return numbers;
	}

	Judgement judge(int[] guess, int[] answer) {
		int strikeCount = getStrikeCount(guess, answer);
		int ballCount = getBallCount(guess, answer);

		return new Judgement.Builder(strikeCount, ballCount).build();
	}

	private int getStrikeCount(int[] guess, int[] answer) {
		int count = 0;

		for (int i = 0; i < numberLength; i++) {
			count = isStrike(i, guess, answer) ? count + 1 : count;
		}

		return count;
	}

	private int getBallCount(int[] guess, int[] answer) {
		int count = 0;
		Set<Integer> answerSet = getNumberSet(answer);

		for (int i = 0; i < numberLength; i++) {
			count = isBall(i, guess, answer, answerSet) ? count + 1 : count;
		}

		return count;
	}

	private boolean isBall(int index, int[] guess, int[] answer, Set<Integer> answerSet) {
		return !isStrike(index, guess, answer) && answerSet.contains(guess[index]);
	}

	private boolean isStrike(int index, int[] guess, int[] answer) {
		return guess[index] == answer[index];
	}

	private Set<Integer> getNumberSet(int[] numbers) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numberLength; i++) {
			set.add(numbers[i]);
		}

		return set;
	}

}
