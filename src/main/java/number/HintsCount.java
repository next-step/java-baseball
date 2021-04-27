package number;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HintsCount {
	private static final int DEFAULT_HINT_COUNT = 0;
	private final Map<Hint, Integer> countByHint;

	private HintsCount(Map<Hint, Integer> countByHint) {
		this.countByHint = Collections.unmodifiableMap(countByHint);
	}

	static HintsCount of(List<Hint> hints) {
		return new HintsCount(countByHint(hints));
	}

	private static Map<Hint, Integer> countByHint(List<Hint> hints) {
		Map<Hint, Integer> countByHint = new HashMap<>();
		for (Hint hint : hints) {
			Integer count = countByHint.getOrDefault(hint, DEFAULT_HINT_COUNT);
			countByHint.put(hint, ++count);
		}
		return countByHint;
	}

	private int countOfHint(Hint hint) {
		return countByHint.getOrDefault(hint, DEFAULT_HINT_COUNT);
	}

	public int countOfStrike() {
		return countOfHint(Hint.STRIKE);
	}

	public int countOfBall() {
		return countOfHint(Hint.BALL);
	}
}
