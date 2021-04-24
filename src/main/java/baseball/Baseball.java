package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int SIZE_OF_NUMBERS = 3;
	List<Integer> answerNumbers;

	public void makeAnswerNumbers() {
		answerNumbers = new ArrayList<>();
		while (answerNumbers.size() < SIZE_OF_NUMBERS) {
			makeUniqueAnswerNumber();
		}
	}

	private void makeUniqueAnswerNumber() {
		Random rand = new Random();
		int number = rand.nextInt(MAX_NUMBER) + MIN_NUMBER;
		if (answerNumbers.contains(number)) {
			return;
		}
		answerNumbers.add(number);
	}
}
