package baseball.util;

import java.util.List;

import baseball.constant.MatchResult;
import baseball.domain.BaseballNumber;

public class BaseballMatcher {
	private BaseballNumber target;

	public BaseballMatcher(BaseballNumber numbers) {
		target = numbers;
	}

	public MatchResult[] match(BaseballNumber guess) {
		List<Integer> guessNumber = guess.getNumbers();
		MatchResult[] results = new MatchResult[guessNumber.size()];

		for (int i = 0; i < guessNumber.size(); i++) {
			results[i] = matchInternal(target, i, guessNumber.get(i));
		}
		return results;
	}

	private MatchResult matchInternal(BaseballNumber target, int numberIdx, int guessNumber) {
		List<Integer> targetNumbers = target.getNumbers();

		if (targetNumbers.get(numberIdx) == guessNumber) {
			return MatchResult.STRIKE;
		} else if (targetNumbers.contains(guessNumber)) {
			return MatchResult.BALL;
		}
		return MatchResult.NOTHING;
	}

	public BaseballNumber getTarget() {
		return target;
	}
}
