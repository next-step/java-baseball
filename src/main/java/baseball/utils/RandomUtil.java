package baseball.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
	/**
	 *
	 * @param size : list size
	 * @return List<Integer> with non duplicated 1-9 random numbers
	 */
	public static List<Integer> createNonDuplicatedNumberList(int size) {
		List<Integer> intList = new ArrayList<>();
		for (int i = 1; i < 10; ++i) {
			intList.add(i);
		}
		Collections.shuffle(intList);
		return intList.subList(0, size);
	}
}
