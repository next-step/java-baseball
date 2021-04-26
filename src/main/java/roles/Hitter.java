package roles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import constants.PlayRules;

public class Hitter {
	private static Random random = new Random();

	public List<Integer> generateNumber() {
		Set<Integer> numberSet = new HashSet<>();
		while (numberSet.size() < PlayRules.BALL_LENGTH.value()) {
			numberSet.add(random.nextInt(PlayRules.MAX_NUMBER.value()) + 1);
		}
		return new ArrayList<>(numberSet);
	}
}
