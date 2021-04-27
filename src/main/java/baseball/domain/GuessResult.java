package baseball.domain;

import baseball.constant.MatchResult;

public class GuessResult {
	private final MatchResult[] results;
	private int strikes;
	private int balls;
	private int nothings;

	public GuessResult(MatchResult[] results) {
		this.results = results;
		countResult();
	}

	private void countResult() {
		for (MatchResult result : results) {
			matchResult(result);
		}

	}

	private void matchResult(MatchResult result) {
		if (result.equals(MatchResult.STRIKE)) {
			strikes++;
		} else if (result.equals(MatchResult.BALL)) {
			balls++;
		} else if (result.equals(MatchResult.NOTHING)) {
			nothings++;
		}
	}

	public boolean isNothing() {
		return strikes == 0 && balls == 0;
	}

	public int getStrikes() {
		return strikes;
	}

	public int getBalls() {
		return balls;
	}
}
