package play;

import java.util.HashSet;
import java.util.Set;

public class RandomNumProcess {

	public static Set<Integer> randomNumOccur() {
		Set<Integer> ranNumSet = new HashSet<Integer>();

		while (ranNumSet.size() < 3) {
			ranNumSet.add((int)(Math.random() * 9 + 1));
		}

		return ranNumSet;
	}
}
