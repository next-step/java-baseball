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

	void setAnswerNumbers(List<Integer> value) {
		answerNumbers = value;
	}

	public boolean checkAnswer(List<Integer> numbers) {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int number = numbers.get(i);
			if (answerNumbers.contains(number) && answerNumbers.get(i) == number) {
				strikeCount++;
			} else if (answerNumbers.contains(number) && answerNumbers.get(i) != number) {
				ballCount++;
			}
		}
		String ballCountString = "";
		if (strikeCount > 0 && ballCount > 0) {
			ballCountString = String.format("%d 스트라이크 %d볼", strikeCount, ballCount);
		} else if (strikeCount > 0 && ballCount == 0) {
			ballCountString = String.format("%d 스트라이크", strikeCount);
		} else if (strikeCount == 0 && ballCount > 0) {
			ballCountString = String.format("%d볼", ballCount);
		} else if (strikeCount == 0 && ballCount == 0) {
			ballCountString = "낫싱";
		}
		System.out.println(ballCountString);
		return strikeCount == SIZE_OF_NUMBERS;
	}
}
