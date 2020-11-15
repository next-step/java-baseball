package domain.baseballRule;

import java.util.List;

public class BaseballNumbers {
	private final List<Integer> baseballNumbers;

	public BaseballNumbers(List<Integer> baseballNumbers) {
		this.baseballNumbers = baseballNumbers;
	}

	public static BaseballNumbers newOpponentBaseballNumbers(List<Integer> baseballNumbers) {
		return new BaseballNumbers(baseballNumbers);
	}

	public static BaseballNumbers newPlayerBaseballNumbers(List<Integer> baseballNumbers) {
		if (baseballNumbers.size() > 3)
			baseballNumbers = baseballNumbers.subList(0, 2);
		return new BaseballNumbers(baseballNumbers);
	}

	public Integer getByIndex(int index) {
		return this.baseballNumbers.get(index);
	}

	public Integer size() {
		return this.baseballNumbers.size();
	}

	public List<Integer> baseballNumbers() {
		return this.baseballNumbers;
	}
}
