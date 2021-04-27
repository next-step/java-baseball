package baseball.utils;

import java.util.List;

public class IntegerUtil {
	/**
	 * compare values and return 1 if same values
	 * @return 1 if val == val2, 0, if val1 != val2
	 */
	public static int compareValues(Integer val1, Integer val2) {
		return val1.equals(val2) ? 1 : 0;
	}

	/**
	 * list parameter should contain value parameter. but not on same index.
	 */
	public static boolean containsValueNotOnSameIndex(
			List<Integer> list, Integer value, int index) {
		return list.contains(value) && list.indexOf(value) != index;
	}
}
