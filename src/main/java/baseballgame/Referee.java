package baseballgame;

import java.util.List;

public class Referee {

	private List<Integer> answerList;
	private int containsCount = 0;
	private int strikeCount = 0;

	public Referee(List<Integer> answerList) {
		this.answerList = answerList;
	}

	public void judgeBall(int[] userInputArray) {
		for (int index = 0; index < answerList.size(); index++) {
			plusContainsCount(userInputArray[index]);
			plusStrikeCount(answerList.get(index), userInputArray[index]);
		}
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return containsCount - strikeCount;
	}

	private void plusContainsCount(int userInput) {
		if (answerList.contains(userInput)) {
			containsCount++;
		}
	}

	private void plusStrikeCount(int answerNumber, int userInput) {
		if (answerNumber == userInput) {
			strikeCount++;
		}
	}
}
