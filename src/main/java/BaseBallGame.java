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
}