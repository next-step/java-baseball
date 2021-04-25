package nextstep.study.baseball.domain.strategy;

import nextstep.study.baseball.domain.DecisionResult;

public interface OutStrategy {

	public boolean isOut(DecisionResult decisionResult);

}
