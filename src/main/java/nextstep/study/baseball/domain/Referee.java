package nextstep.study.baseball.domain;

import nextstep.study.baseball.domain.strategy.DecisionStrategy;
import nextstep.study.baseball.domain.strategy.DefaultDecisionStrategy;
import nextstep.study.baseball.domain.strategy.DefaultOutStrategy;
import nextstep.study.baseball.domain.strategy.OutStrategy;

import java.util.List;

public class Referee {

	private DecisionStrategy decisionStrategy;
	private OutStrategy outStrategy;

	public Referee() {
		this.decisionStrategy = new DefaultDecisionStrategy();
		this.outStrategy = new DefaultOutStrategy();
	}

	public Referee(DecisionStrategy decisionStrategy, OutStrategy outStrategy) {
		this.decisionStrategy = decisionStrategy;
		this.outStrategy = outStrategy;
	}

	public DecisionResult makeDecisionResult(List<Integer> batterNumbers,
		List<Integer> pitcherNumbers) {

		DecisionResult decisionResult = new DecisionResult();

		for (int i = 0; i < batterNumbers.size(); i++) {
			int batterNumber = batterNumbers.get(i);
			Decision decision = this.decisionStrategy.decide(i, batterNumber, pitcherNumbers);
			decisionResult.addDecision(decision);
		}
		return decisionResult;
	}

	public boolean isOut(DecisionResult decisionResult) {
		return this.outStrategy.isOut(decisionResult);
	}

	public void setDecisionStrategy(DecisionStrategy decisionStrategy) {
		this.decisionStrategy = decisionStrategy;
	}

	public void setOutStrategy(OutStrategy outStrategy) {
		this.outStrategy = outStrategy;
	}
}
