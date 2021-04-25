package nextstep.study.baseball.domain.strategy;

import nextstep.study.baseball.common.BaseConstants;
import nextstep.study.baseball.domain.DecisionResult;

public class DefaultOutStrategy implements OutStrategy {

	@Override
	public boolean isOut(DecisionResult decisionResult) {
		return decisionResult.getStrikeCount() >= BaseConstants.FINISH_STRIKE_OUT;
	}

}
