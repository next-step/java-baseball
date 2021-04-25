package baseball.domain;

import java.util.List;

public class BaseballNumbers {

	private final static int MAX_BASEBALL_NUMBER_COUNT = 3;

	private final List<BaseballNumber> baseballNumbers;

	public static BaseballNumbers newAutoBaseballNumbers() {
		return new BaseballNumbers(BaseballNumbersFactory.create(MAX_BASEBALL_NUMBER_COUNT));
	}

	private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
		this.baseballNumbers = baseballNumbers;
	}

}
