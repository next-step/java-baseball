package domain;

import java.util.List;

public class BaseballNumbers {
	private final List<Integer> baseballNumbers;

	public BaseballNumbers(List<Integer> baseballNumbers) {
		this.baseballNumbers = baseballNumbers;
	}

	public static BaseballNumbers newOpponentBaseballNumbers(List<Integer> baseballNumbers) {
		return new BaseballNumbers(baseballNumbers);
	}

	public Integer getByIndex(int index) {
		return this.baseballNumbers.get(index);
	}

	public Integer size() {
		return this.baseballNumbers.size();
	}
}
