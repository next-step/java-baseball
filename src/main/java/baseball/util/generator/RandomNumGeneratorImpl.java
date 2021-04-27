package baseball.util.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import baseball.domain.BallNumber;

public class RandomNumGeneratorImpl implements NumGenerator {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final Random random;

	public RandomNumGeneratorImpl() {
		this.random = new Random();
	}

	@Override
	public Map<BallNumber, Integer> generate() {
		Map<BallNumber, Integer> ballNumMap = new HashMap<>();
		int index = 0;

		while (ballNumMap.size() != 3) {
			int num = random.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
			index = putData(ballNumMap, new BallNumber(num), index);
		}

		return ballNumMap;
	}

	private int putData(Map<BallNumber, Integer> ballNumMap, BallNumber ballNumber, int index) {
		int newIndex = index;

		if (Objects.isNull(ballNumMap.putIfAbsent(ballNumber, index))) {
			newIndex++;
		}
		return newIndex;
	}
}
