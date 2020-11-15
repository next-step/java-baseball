package domain;

import java.util.List;

import domain.baseballRule.BaseballNumbers;

public class Player {
	private BaseballNumbers baseballNumbers;

	public Player() {
	}

	public BaseballNumbers inputBaseballNumbers(List<Integer> baseballNumbers) {
		this.baseballNumbers = BaseballNumbers.newPlayerBaseballNumbers(baseballNumbers);
		return this.baseballNumbers;
	}
}

