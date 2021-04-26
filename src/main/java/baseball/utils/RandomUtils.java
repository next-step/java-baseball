package baseball.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomUtils {
	public static final int NUMBER_LENGTH = 3;
	private static final Random RANDOM = new Random();

	public RandomUtils() {
	}

	public static int[] createRandomNumber(final int min, final int max) {
		checkMinGreaterThanMax(min, max);
		checkMinLessThanOne(min);
		checkMinEqualMax(min, max);

		return getResultArray(getResultSet(min, max));
	}

	private static void checkMinEqualMax(int min, int max) {
		if (min == max) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	private static void checkMinLessThanOne(int min) {
		if (min < 1) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	private static void checkMinGreaterThanMax(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	private static Set<Integer> getResultSet(final int min, final int max) {
		Set<Integer> resultSet = new HashSet<>();

		while (resultSet.size() != NUMBER_LENGTH) {
			resultSet.add(RANDOM.nextInt(max - min + 1) + min);
		}

		return resultSet;
	}

	private static int[] getResultArray(Set<Integer> resultSet) {
		int[] numberArray = new int[NUMBER_LENGTH];
		int index = 0;
		Iterator<Integer> iterator = resultSet.iterator();

		while (iterator.hasNext()) {
			numberArray[index] = iterator.next();
			index++;
		}

		return numberArray;
	}
}
