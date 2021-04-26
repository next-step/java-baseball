package baseball.domain;

import java.util.EnumMap;
import java.util.Map;

public class BaseballGameMatchResult {

	private final Map<BaseballNumberMatch, Integer> matchResult = new EnumMap<>(BaseballNumberMatch.class);

	public void increaseMatchCount(BaseballNumberMatch baseballNumberMatch) {
		if (baseballNumberMatch != null) {
			matchResult.put(baseballNumberMatch, getMatchCount(baseballNumberMatch) + 1);
		}
	}

	public int getMatchCount(BaseballNumberMatch baseballNumberMatch) {
		return matchResult.getOrDefault(baseballNumberMatch, 0);
	}

	public boolean isAllMatch(BaseballNumberMatch baseballNumberMatch) {
		return (getMatchCount(baseballNumberMatch) == BaseballNumbers.MAX_BASEBALL_NUMBER_COUNT);
	}

}
