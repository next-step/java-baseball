package baseball;

import java.util.List;

public class BallUtil {

	public static boolean isNotDuplicateNumber(List<Integer> numbers) {
		if (numbers.get(0).equals(numbers.get(1))) {
			return false;
		}

		if (numbers.get(0).equals(numbers.get(2))) {
			return false;
		}

		if (numbers.get(1).equals(numbers.get(2))) {
			return false;
		}

		return true;
	}
}
