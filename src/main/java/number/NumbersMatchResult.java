package number;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbersMatchResult {
	private static final int DEFAULT_COUNT = 0;
	private final Map<MatchResult, Integer> countByMatchResult;

	private NumbersMatchResult(Map<MatchResult, Integer> countByMatchResult) {
		this.countByMatchResult = Collections.unmodifiableMap(countByMatchResult);
	}

	static NumbersMatchResult of(List<MatchResult> matchResults) {
		return new NumbersMatchResult(countByMatchResult(matchResults));
	}

	private static Map<MatchResult, Integer> countByMatchResult(List<MatchResult> matchResults) {
		Map<MatchResult, Integer> countByNumberMatchResult = new HashMap<>();
		for (MatchResult matchResult : matchResults) {
			Integer count = countByNumberMatchResult.getOrDefault(matchResult, DEFAULT_COUNT);
			countByNumberMatchResult.put(matchResult, ++count);
		}
		return countByNumberMatchResult;
	}

	public int countOfResult(MatchResult matchResult) {
		return countByMatchResult.getOrDefault(matchResult, DEFAULT_COUNT);
	}
}
