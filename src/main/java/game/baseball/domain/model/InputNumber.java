package game.baseball.domain.model;

import java.util.List;

import game.baseball.domain.shared.NumberUtils;

public class InputNumber extends BaseBallNumber {

	private InputNumber(List<Integer> numbers) {
		super(numbers);
	}

	public static InputNumber generate(int number) {
		return new InputNumber(NumberUtils.split(number));
	}
}
