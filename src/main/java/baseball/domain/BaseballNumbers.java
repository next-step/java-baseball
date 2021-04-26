package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

	public static final int MAX_BASEBALL_NUMBER_COUNT = 3;

	private final List<BaseballNumber> baseballNumbers;

	public static BaseballNumbers newAutoBaseballNumbers() {
		return new BaseballNumbers(BaseballNumbersFactory.create(MAX_BASEBALL_NUMBER_COUNT));
	}

	public static BaseballNumbers newBaseballNumbers(List<BaseballNumber> baseballNumbers) {
		return new BaseballNumbers(baseballNumbers);
	}

	private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
		validate(baseballNumbers);

		this.baseballNumbers = baseballNumbers;
	}

	private void validate(List<BaseballNumber> baseballNumbers) {
		if (baseballNumbers.size() != MAX_BASEBALL_NUMBER_COUNT) {
			throw new IllegalArgumentException(MAX_BASEBALL_NUMBER_COUNT + "자리 숫자여야 합니다.");
		}

		Set<BaseballNumber> set = new HashSet<>(baseballNumbers);
		if (set.size() < MAX_BASEBALL_NUMBER_COUNT) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	public BaseballGameMatchResult getBaseballGameMatchResult(BaseballNumbers other) {
		BaseballGameMatchResult matchResult = new BaseballGameMatchResult();
		for (int i = 0; i < MAX_BASEBALL_NUMBER_COUNT; i++) {
			BaseballNumberMatch baseballNumbersMatch = other.getBaseballNumberMatch(i, baseballNumbers.get(i));
			matchResult.increaseMatchCount(baseballNumbersMatch);
		}

		return matchResult;
	}

	private BaseballNumberMatch getBaseballNumberMatch(int position, BaseballNumber compareNumber) {
		if (baseballNumbers.get(position).equals(compareNumber)) {
			return BaseballNumberMatch.STRIKE;
		}

		if (baseballNumbers.contains(compareNumber)) {
			return BaseballNumberMatch.BALL;
		}

		return BaseballNumberMatch.NOTHING;
	}

}
