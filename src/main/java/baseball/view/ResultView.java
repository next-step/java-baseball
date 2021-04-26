package baseball.view;

import baseball.domain.BaseballGameMatchResult;
import baseball.domain.BaseballNumberMatch;
import baseball.domain.BaseballNumbers;

public class ResultView {

	private static final String FINISH_MESSAGE = BaseballNumbers.MAX_BASEBALL_NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

	private ResultView() { }

	public static void printMatchResult(BaseballGameMatchResult matchResult) {
		if (matchResult.isAllMatch(BaseballNumberMatch.STRIKE)) {
			System.out.println(getAllStrikeAndFinishMessage(matchResult));
			return;
		}

		if (matchResult.isAllMatch(BaseballNumberMatch.NOTHING)) {
			System.out.println(BaseballNumberMatch.NOTHING.getName());
			return;
		}

		System.out.println(getResultMatchMessage(matchResult));
	}

	private static String getAllStrikeAndFinishMessage(BaseballGameMatchResult matchResult) {
		return getMatchMessage(matchResult, BaseballNumberMatch.STRIKE) + "\n" + FINISH_MESSAGE;
	}

	private static String getMatchMessage(BaseballGameMatchResult matchResult, BaseballNumberMatch numberMatch) {
		int matchCount = matchResult.getMatchCount(numberMatch);
		return matchCount == 0 ? "" : String.format("%d %s ", matchCount, numberMatch.getName());
	}

	private static String getResultMatchMessage(BaseballGameMatchResult matchResult) {
		return getMatchMessage(matchResult, BaseballNumberMatch.STRIKE) + getMatchMessage(matchResult, BaseballNumberMatch.BALL);
	}

}
