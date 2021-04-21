package nextstep.study.baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Batter {

	public List<Integer> generateRandomNumbers(int length) {
		if (length == 0) {
			return new ArrayList();
		}

		Set<Integer> set = new HashSet<>();
		while (set.size() < length) {
			Double value = (Math.random() * 9) + 1;
			set.add(value.intValue());
		}
		List<Integer> list = new ArrayList<>(set);

		return list;
	}

}
