import java.util.List;

public class Feedback {
	public GameResult compare(List<Integer> answer, List<Integer> question) {
		GameResult gameResult = new GameResult();
		gameResult.setStrike(compareSamePosition(answer, question));
		gameResult.setBall(compareDifferentPosition(answer, question));
		return gameResult;
	}

	public int compareDifferentPosition(List<Integer> answer, List<Integer> question) {
		int ball = 0;
		for (int index = 0; index < answer.size(); index++) {
			int nextIndex = (index + 1) % 3;
			int nextNextIndex = (index + 2) % 3;
			ball = ball + (isSameNumber(answer.get(index), question.get(nextIndex)) ? 1 : 0);
			ball = ball + (isSameNumber(answer.get(index), question.get(nextNextIndex)) ? 1 : 0);
		}
		return ball;
	}

	public int compareSamePosition(List<Integer> answer, List<Integer> question) {
		int strike = 0;
		for (int index = 0; index < answer.size(); index++) {
			strike = strike + (isSameNumber(answer.get(index), question.get(index)) ? 1 : 0);
		}
		return strike;
	}

	public boolean isSameNumber(Integer targetNumber, Integer comparedNumber) {
		return targetNumber.equals(comparedNumber);
	}

}
