package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
public class RandomNumberGenerator {

	public static List<Integer> generate() {
		List<Integer> candidates = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(candidates);
		return candidates.subList(0, 3);
	}
}
