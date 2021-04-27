import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

public class BaseBallGame {
	public static int getRandomNumber() {
		return new Random().nextInt(9) + 1;
	}

	public static int[] getRandomNumber3Length() {
		int[] targetNumber = new int[3];

		int count = 0;
		while (count < 3) {
			count = createRandomNumber3Length(targetNumber, count);
		}

		return targetNumber;
	}

	private static int createRandomNumber3Length(int[] target, int count) {
		int number = getRandomNumber();
		if (!ArrayUtils.contains(target, number)) {
			target[count] = number;
			count++;
		}
		return count;
	}

	public static int getStrikeCount(int[] target, int[] inputNumbers) {
		int strike = 0;
		for (int i = 0; i < target.length; i++) {
			strike = getStrikeCountCondition(target[i], inputNumbers[i], strike);
		}
		return strike;
	}

	private static int getStrikeCountCondition(int target, int inputNumber, int count) {
		return (target == inputNumber) ? count + 1 : count;
	}

	public static int getBallCount(int[] target, int[] inputNumbers) {
		int ball = 0;
		for (int i = 0; i < inputNumbers.length; i++) {
			ball = getBallCountCondition(target, inputNumbers, i, ball);
		}
		return ball;
	}

	private static int getBallCountCondition(int[] target, int[] inputNumbers, int index, int count) {
		return (ArrayUtils.indexOf(target, inputNumbers[index]) > -1 && target[index] != inputNumbers[index])
			? count + 1 : count;
	}
}