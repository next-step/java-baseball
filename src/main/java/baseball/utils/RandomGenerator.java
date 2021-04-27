package baseball.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import baseball.domain.Game;

public class RandomGenerator {
	private final int MAX_NUMBER = 9;
	private final int MIN_NUMBER = 1;
	private List<Integer> CandidateNumbers;
	private List<Integer> SelectedNumbers;

	public RandomGenerator() {
		this.CandidateNumbers = new ArrayList<>();
		initAllNumbers();
	}

	private void initAllNumbers() {
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			CandidateNumbers.add(i);
		}
	}

	public List<Integer> makeRandomNumbers() {
		SelectedNumbers = new ArrayList<>();
		Random random = new Random();
		while (SelectedNumbers.size() < Game.NUMBER_LENGTH) {
			int number = random.nextInt(CandidateNumbers.size());
			SelectedNumbers.add(CandidateNumbers.get(number));
			CandidateNumbers.remove(number);
		}
		return SelectedNumbers;
	}
}
