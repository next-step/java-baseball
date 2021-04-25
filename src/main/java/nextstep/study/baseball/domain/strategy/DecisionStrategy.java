package nextstep.study.baseball.domain.strategy;

import nextstep.study.baseball.domain.Decision;

import java.util.List;

public interface DecisionStrategy {

	public Decision decide(int index, int betterNumber, List<Integer> pitcherNumbers);

}
