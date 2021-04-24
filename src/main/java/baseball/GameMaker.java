package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameMaker {
	public Set<Integer> generateRandomNumber() {
		Random random = new Random();
		Set<Integer> numberSet = new HashSet<>();
		do {
			numberSet.add(random.nextInt(9) + 1);
		} while (numberSet.size() < 3);
		return numberSet;
	}
}
