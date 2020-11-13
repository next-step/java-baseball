package baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GenerateComputerNumber {

	// Min inclusive but Max exclusive
	public static Integer generateEachNumberBetweenMinAndMax(int min, int max) {
		Random random = new Random();
		return random.ints(min, max).findFirst().getAsInt();
	}

	public static Set<Integer> generateComputerNumber() {
		Set<Integer> computerNumbers= new LinkedHashSet<>();

		while(computerNumbers.size()<3) {
			computerNumbers.add(generateEachNumberBetweenMinAndMax(1,9));
		}

		return computerNumbers;
	}
}
