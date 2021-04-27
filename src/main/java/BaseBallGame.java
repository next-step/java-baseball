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
			int number = getRandomNumber();
			if (!ArrayUtils.contains(targetNumber, number)) {
				targetNumber[count] = number;
				count++;
			}
		}

		return targetNumber;
	}
}