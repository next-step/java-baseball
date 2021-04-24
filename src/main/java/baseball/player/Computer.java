package baseball.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import type.PitchingResultType;

public class Computer extends Player {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final List<Integer> NUMBER_POOL = new ArrayList<>();

	protected Computer(int numberSize) {
		for (int i = MIN_NUMBER; i < MAX_NUMBER + 1; i++) {
			NUMBER_POOL.add(i);
		}

		updateNumberList(generateRandomNumberList(numberSize));
	}

	private List<Integer> generateRandomNumberList(int numberSize) {
		Collections.shuffle(NUMBER_POOL);
		List<Integer> newNumberList = new ArrayList<>();
		for (int i = 0; i < numberSize; i++) {
			newNumberList.add(NUMBER_POOL.get(i));
		}

		return newNumberList;
	}

	public static Computer of(int numberSize) {
		return new Computer(numberSize);
	}

	public PitchingResultType checkNumber(int number, int position) {
		if (getNumberList().get(position) == number) {
			return PitchingResultType.STRIKE;
		}

		if (getNumberList().contains(number)) {
			return PitchingResultType.BALL;
		}

		return PitchingResultType.OUT;
	}

	/**
	 * 길이는 같지만, 다른 번호를 할당합니다.
	 */
	public void reset() {
		int currentNumberSize = getNumberList().size();
		updateNumberList(generateRandomNumberList(currentNumberSize));
	}
}
