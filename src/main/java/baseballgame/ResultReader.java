package baseballgame;

import java.util.List;

public class ResultReader {
	private final static int NUMBER_OF_DIGIT = 3;
	private static StringBuilder result = null;
	private static List<Integer> redundancy = null;

	public int validateStrike(List<Integer> answer, List<Integer> userInput) {
		int count = 0;
		for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
			if (answer.get(i) == userInput.get(i)) {
				count++;
				continue;
			}
			redundancy.add(userInput.get(i));
		}
		combinateString(count, " 스트라이크 ");
		return count;
	}

	private void combinateString(int successCount, String targetString) {
		if (successCount != 0) {
			result.append(successCount + targetString);
		}
	}
}
