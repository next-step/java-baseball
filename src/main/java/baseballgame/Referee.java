package baseballgame;

import java.util.List;

public class Referee {
	private int containsCount = 0;
	private int strikeCount = 0;

	public BaseBallResult judgeBall(List<Integer> answerList, String userInput) {
		int[] userInputArray = getUserInputArray(userInput);
		for (int index = 0; index < answerList.size(); index++) {
			plusContainsCount(answerList, userInputArray[index]);
			plusStrikeCount(answerList.get(index), userInputArray[index]);
		}
		return new BaseBallResult(containsCount, strikeCount);
	}

	public void initCount() {
		containsCount = 0;
		strikeCount = 0;
	}

	private void plusContainsCount(List<Integer> answerList, int userInput) {
		if (answerList.contains(userInput)) {
			containsCount++;
		}
	}

	private void plusStrikeCount(int answerNumber, int userInput) {
		if (answerNumber == userInput) {
			strikeCount++;
		}
	}

	private int[] getUserInputArray(String userInput) {
		String[] userStringInputArray = userInput.split("");
		int[] userInputArray = new int[userStringInputArray.length];
		for (int i = 0; i < userStringInputArray.length; i++) {
			userInputArray[i] = Integer.parseInt(userStringInputArray[i]);
		}
		return userInputArray;
	}
}
