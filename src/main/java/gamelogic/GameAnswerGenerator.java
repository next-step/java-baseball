package gamelogic;

import java.util.Random;

public class GameAnswerGenerator {
	
	private final Random random = new Random();

	public String generateAnswer() {
		int answerCandidate = generateAnswerCandidate();
		while (!isValidAnswer(answerCandidate)) {
			answerCandidate = generateAnswerCandidate();
		}
		return Integer.toString(answerCandidate);
	}

	private int generateAnswerCandidate() {
		int candidate = 0;
		for (int i = 0; i < 3; i++) {
			candidate = candidate * 10 + (random.nextInt(9) + 1);
		}
		return candidate;
	}

	private boolean isValidAnswer(int candidate) {
		int firstDigit = candidate / 100;
		int secondDigit = (candidate / 10) % 10;
		int thirdDigit = candidate % 10;
		return (firstDigit != secondDigit && secondDigit != thirdDigit && thirdDigit != firstDigit);
	}
}
