package nextstep.study.baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class DecisionResult {

	private Map<Decision, Integer> map;

	public DecisionResult() {
		this.map = new HashMap<>();
		this.init();
	}

	public DecisionResult(int strikeCount, int ballCount, int nothingCount) {
		this.map = new HashMap<>();
		this.init(strikeCount, ballCount, nothingCount);
	}

	public void init() {
		map.clear();
		map.put(Decision.STRIKE, 0);
		map.put(Decision.BALL, 0);
		map.put(Decision.NOTHING, 0);
	}

	public void init(int strikeCount, int ballCount, int nothingCount) {
		map.clear();
		map.put(Decision.STRIKE, strikeCount);
		map.put(Decision.BALL, ballCount);
		map.put(Decision.NOTHING, nothingCount);
	}

	public void addDecision(Decision type) {
		Integer count = map.get(type);
		map.put(type, ++count);
	}

	public int getStrikeCount() {
		return map.get(Decision.STRIKE);
	}

	public int getBallCount() {
		return map.get(Decision.BALL);
	}

	public int getNothingCount() {
		return map.get(Decision.NOTHING);
	}

	@Override
	public String toString() {
		return "DecisionResult{" +
				"map=" + map +
				'}';
	}
}
