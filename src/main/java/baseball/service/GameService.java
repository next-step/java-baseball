package baseball.service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GameService {

	public Set<Integer> generateNumber() {
		Random random = new Random();
		Set<Integer> numbers = new LinkedHashSet<>();
		do {
			numbers.add(random.nextInt(9) + 1);
		} while (numbers.size() < 3);
		return numbers;
	}

}
