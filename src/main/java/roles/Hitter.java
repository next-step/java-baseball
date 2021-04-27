package roles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import constants.PlayRules;

public class Hitter {

	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void generateNumber() {
		Random random = new Random();
		Set<Integer> numberSet = new HashSet<>();
		while (numberSet.size() < PlayRules.BALL_LENGTH.value()) {
			numberSet.add(random.nextInt(PlayRules.MAX_NUMBER.value()) + 1);
		}
		this.numbers = new ArrayList<>(numberSet);
	}
}
