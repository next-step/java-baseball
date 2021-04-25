import number.MatchResult;
import number.NumbersMatchResult;

public class StrikeFirstResultRenderer implements NumberMatchResultRenderer {
	private static final String EMPTY = "";
	private static final String SPACE = " ";
	private static final String NOTHING = "낫싱";
	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";

	@Override
	public String render(NumbersMatchResult numbersMatchResult) {
		int strikeCount = numbersMatchResult.countOfResult(MatchResult.STRIKE);
		int ballCount = numbersMatchResult.countOfResult(MatchResult.BALL);
		return render(strikeCount, ballCount);
	}

	private String render(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			return NOTHING;
		}
		String strikeResult = strikeCount > 0 ? strikeCount + SPACE + STRIKE : EMPTY;
		String ballResult = ballCount > 0 ? ballCount + BALL : EMPTY;
		return String.join(SPACE, strikeResult, ballResult).trim();
	}

}
