package baseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GameStarter {
	private final int NUMBER_OF_DIGIT = 3;
	private static ResultReader resultReader = new ResultReader();
	private static List<Integer> answer = null;
	private int totalCount = 0;

	public GameStarter() {
		setAnswerNumber();
	}

	public void setAnswerNumber() {
		Random answerNumber = new Random();
		answer = new ArrayList<Integer>();
		Set<Integer> deduplicationAnswerNumber = new HashSet<Integer>();
		while (deduplicationAnswerNumber.size() < NUMBER_OF_DIGIT) {
			deduplicationAnswerNumber.add(answerNumber.nextInt(8) + 1);
		}
		answer.addAll(deduplicationAnswerNumber);
	}

}
