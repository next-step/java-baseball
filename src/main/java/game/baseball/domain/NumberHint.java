package game.baseball.domain;

import java.util.List;
import java.util.function.Predicate;

public class NumberHint {

	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";

	private final List<Decision> decisions;

	public NumberHint(List<Decision> decisions) {
		this.decisions = decisions;
	}

	public boolean isThreeStrike() {
		return hasNotBall() && hasNotNone();
	}

	public boolean isNothing() {
		return hasNotStrike() && hasNotBall();
	}

	public int strikeCount() {
		return count(decision -> decision == Decision.STRIKE);
	}

	public int ballCount() {
		return count(decision -> decision == Decision.BALL);
	}

	public String getMarking() {
		if (isNothing()) {
			return NOTHING;
		}

		return String.format("%d%s %d%s", strikeCount(), STRIKE, ballCount(), BALL);
	}

	private boolean hasNotBall() {
		return !decisions.contains(Decision.BALL);
	}

	private boolean hasNotStrike() {
		return !decisions.contains(Decision.STRIKE);
	}

	private boolean hasNotNone() {
		return !decisions.contains(Decision.NONE);
	}

	private int count(Predicate<Decision> predicate) {
		int count = 0;
		for (Decision decision : decisions) {
			count += predicate.test(decision) ? 1 : 0;
		}
		return count;
	}
}
