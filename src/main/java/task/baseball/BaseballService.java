package task.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseballService {

	private static final int NUM_SIZE = 3;

	public List<Integer> generateRandomAnswer() {
		Set<Integer> randomSet = new HashSet<>(3);

		while (randomSet.size() < NUM_SIZE) {
			Random rand = new Random();
			randomSet.add(rand.nextInt(10));
		}

		return new ArrayList<>(randomSet);
	}

	public int getStrikeCount(int[] input, List<Integer> answer) {

		int strikeCount = 0;

		for (int i = 0; i < NUM_SIZE; i++) {
			if (input[i] == answer.get(i)) {
				strikeCount++;
			}
		}

		return strikeCount;
	}

	public boolean isAnswer(int strikeCount) {

		return strikeCount == NUM_SIZE;
	}

	public int getBallCount(int[] input, List<Integer> answer) {

		int ballCount = 0;

		for (int i = 0; i < NUM_SIZE; i++) {
			int inputItem = input[i];
			if (inputItem != answer.get(i) && answer.contains(inputItem)) {
				ballCount++;
			}
		}

		return ballCount;
	}

	public boolean isNothing(int strikeCount, int ballCount) {

		return strikeCount == 0 && ballCount == 0;
	}

	public String generateOutputMessage(int strikeCount, int ballCount) {
		StringBuffer message = new StringBuffer();

		if (strikeCount > 0) {
			message.append(strikeCount);
			message.append("스트라이크");
		}

		if (ballCount > 0) {
			if (message.length() > 0) {
				message.append(" ");
			}
			message.append(ballCount);
			message.append("볼");
		}

		return message.toString();
	}

	public String generateAnswerOutputMessage() {

		return "3스트라이크\n3개의숫자를모두맞히셨습니다!게임종료";
	}

	public String generateNotThingOutputMessage() {

		return "낫싱";
	}

	public int[] validateInputAndConvert(String input) {

		return new int[3];
	}

}
