package number;

public enum MatchResult {
	STRIKE(((containEqualNumber, equalPosition) -> containEqualNumber && equalPosition)),
	BALL(((containEqualNumber, equalPosition) -> containEqualNumber && !equalPosition)),
	NOT_MATCH(((containEqualNumber, equalPosition) -> !containEqualNumber && !equalPosition));

	private final MatchRule matchRule;

	MatchResult(MatchRule matchRule) {
		this.matchRule = matchRule;
	}

	private boolean applyRule(boolean containEqualNumber, boolean equalPosition) {
		return matchRule.apply(containEqualNumber, equalPosition);
	}

	static MatchResult applyMatchRules(boolean containEqualNumber, boolean equalPosition) {
		if (STRIKE.applyRule(containEqualNumber, equalPosition)) {
			return STRIKE;
		}
		if (BALL.applyRule(containEqualNumber, equalPosition)) {
			return BALL;
		}
		return NOT_MATCH;
	}
}
