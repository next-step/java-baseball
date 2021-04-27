package baseball.domain.internal;

import java.util.HashMap;
import java.util.Map;

import baseball.domain.BallNumber;
import baseball.domain.Player;

class BaseballPlayerImpl implements Player {

	private Map<BallNumber, Integer> numbers;

	BaseballPlayerImpl() {
		this.numbers = new HashMap<>();
	}

	void setNumbers(Map<BallNumber, Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public Map<BallNumber, Integer> getNumbers() {
		return numbers;
	}
}
