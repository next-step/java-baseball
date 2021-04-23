package nextstep.study.baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

	private Map<DecisionType, Integer> map;

	public Referee() {
		this.map = new HashMap<>();
		this.init();
	}

	public void init() {
		map.clear();
		map.put(DecisionType.STRIKE, 0);
		map.put(DecisionType.BALL, 0);
		map.put(DecisionType.NOTHING, 0);
	}

	public RefreeDecision makeRefreeDecision(List<Integer> batterNums,
		List<Integer> pitcherNums) {

		for (int i = 0; i < batterNums.size(); i++) {
			int number = batterNums.get(i);
			DecisionType type = getDecisionType(i, number, pitcherNums);
			Integer count = map.get(type);
			map.put(type, ++count);
		}
		return new RefreeDecision(
			map.get(DecisionType.STRIKE),
			map.get(DecisionType.BALL),
			map.get(DecisionType.NOTHING));
	}

	public DecisionType getDecisionType(int index, int number, List<Integer> pitcherNums) {
		int targetIndex = pitcherNums.indexOf(number);

		if (targetIndex == -1) {
			return DecisionType.NOTHING;
		}
		if (targetIndex == index) {
			return DecisionType.STRIKE;
		}
		return DecisionType.BALL;
	}

}
