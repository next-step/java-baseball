package nextstep.study.baseball.domain.strategy;

import nextstep.study.baseball.domain.Decision;

import java.util.List;

public class DefaultDecisionStrategy implements DecisionStrategy {

	@Override
	public Decision decide(int index, int betterNumber, List<Integer> pitcherNumbers) {
		int targetIndex = pitcherNumbers.indexOf(betterNumber);

		if (targetIndex == -1) {
			return Decision.NOTHING;
		}
		if (targetIndex == index) {
			return Decision.STRIKE;
		}
		return Decision.BALL;
	}

}
