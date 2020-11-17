package baseball.util;

import baseball.configuration.BaseballConfiguration;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class BaseballUtil {

	private BaseballUtil() {
		throw new IllegalAccessError("Utility class");
	}

	public static String[] getRandomNumbers() {

		String[] randomNumbers = new String[BaseballConfiguration.REQUIRED_COUNT];
		HashSet<Integer> randomSet = new LinkedHashSet<>();

		while (randomSet.size() != BaseballConfiguration.REQUIRED_COUNT) {
			int randomNum = new Random().nextInt(BaseballConfiguration.MAX_NUMBER)
				+ BaseballConfiguration.MIN_NUMBER;
			randomSet.add(randomNum);
		}
		int index = 0;
		for (int randomNum : randomSet) {
			randomNumbers[index++] = String.valueOf(randomNum);
		}
		return randomNumbers;
	}

	public static boolean isAllNumber(String input) {
		char[] inputArray = input.toCharArray();
		int nonNumberCount = 0;
		for (char c : inputArray) {
			nonNumberCount += isNonNumber(c);
		}
		if (nonNumberCount != 0) {
			return false;
		}
		return true;
	}

	private static int isNonNumber(char number) {
		if (!Character.isDigit(number)) {
			return 1;
		}
		return 0;
	}
}
