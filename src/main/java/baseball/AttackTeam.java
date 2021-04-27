package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AttackTeam {
	private String attackNumbers;

	public void prepareAttackNumbers() {
		Set<Integer> numbers = new HashSet<>();

		Random random = new Random();
		while (numbers.size() != 3) {
			numbers.add(random.nextInt(9) + 1);
		}

		StringBuilder numbersBuffer = new StringBuilder();
		for (int number : numbers) {
			numbersBuffer.append(number);
		}

		this.attackNumbers = numbersBuffer.toString();
	}

	public String getAttackNumbers() {
		return this.attackNumbers;
	}
}
