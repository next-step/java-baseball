package play;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RandomNumProcess {

	public static void setRandomNum(Map<Integer, Integer> ranNumMap) {
		setRandomNumMap(randomNumOccur(), ranNumMap);
	}

	public static Set<Integer> randomNumOccur() {
		Set<Integer> ranNumSet = new HashSet<Integer>();

		while (ranNumSet.size() < 3) {
			ranNumSet.add((int)(Math.random() * 9 + 1));
		}

		return ranNumSet;
	}

	public static void setRandomNumMap(Set<Integer> ranNumSet, Map<Integer, Integer> ranNumMap) {
		Iterator<Integer> iter = ranNumSet.iterator();
		int nb = 0;
		while (iter.hasNext()) {
			nb++;
			ranNumMap.put(nb, iter.next());
		}
	}
}