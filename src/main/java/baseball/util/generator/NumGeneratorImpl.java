package baseball.util.generator;

import java.util.HashMap;
import java.util.Map;

import baseball.domain.BallNumber;

public class NumGeneratorImpl implements NumGenerator {

	private final String input;

	public NumGeneratorImpl(String input) {
		this.input = input;
	}

	@Override
	public Map<BallNumber, Integer> generate() {
		Map<BallNumber, Integer> nums = new HashMap<>();

		char[] valueArray = input.toCharArray();

		for (int index = 0; index < valueArray.length; index++) {
			String cValue = String.valueOf(valueArray[index]);
			nums.put(new BallNumber(Integer.parseInt(cValue)), index);
		}

		return nums;
	}
}
