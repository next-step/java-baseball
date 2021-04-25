package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtil {

	public static int[] getRandom3DigitWithoutDuplicates() {
		Set<Integer> usedNumber = new HashSet<>();
		usedNumber.add(0);

		int[] result = new int[3];
		for (int i=0; i<3; i++) {
			result[i] = getNewNumber(usedNumber);
			usedNumber.add(result[i]);
		}

		return result;
	}

	private static int getNewNumber(Set<Integer> usedNumber) {
		Random random = new Random();
		int result = 0;
		while (usedNumber.contains(result)) {
			result = random.nextInt(10);
		}
		return result;
	}
}
