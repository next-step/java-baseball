package baseballgame;

import java.util.List;

public class Referee {

	private int containsCount = 0;
	private int strikeCount = 0;

	public void judgeBall(List<Integer> answerList, int[] userInputArray) {
		for (int index = 0; index < answerList.size(); index++) {
			plusContainsCount(answerList, userInputArray[index]);
			plusStrikeCount(answerList.get(index), userInputArray[index]);
		}
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return containsCount - strikeCount;
	}

	public void initCount(){
		containsCount = 0;
		strikeCount = 0;
	}

	public String getResultString(){
		StringBuilder stringBuilder = new StringBuilder();
		if((getStrikeCount() + getBallCount()) == 0 ){
			stringBuilder.append(PrintMessageEnum.NOTHING);
			return stringBuilder.toString();
		}

		if(getStrikeCount() > 0) {
			stringBuilder.append(String.format(PrintMessageEnum.STRIKE.getMessage(), getStrikeCount()));
		}

		if(getBallCount() > 0 ){
			stringBuilder.append(String.format(PrintMessageEnum.BALL.getMessage(), getBallCount()));
		}

		return stringBuilder.toString();
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
}
