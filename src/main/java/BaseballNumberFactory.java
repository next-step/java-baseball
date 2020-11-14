import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BaseballNumberFactory {

	public BaseballNumber generateRandomBaseballNumber() {
		List<Integer> numbers = new ArrayList<>(generateRandomNumberWithoutDuplicate());
		int randomNumberForUnits = numbers.get(0);
		int randomNumberForTens = numbers.get(1);
		int randomNumberForHundreds = numbers.get(2);

		return new BaseballNumber(randomNumberForUnits, randomNumberForTens, randomNumberForHundreds);
	}

	private HashSet<Integer> generateRandomNumberWithoutDuplicate() {

		HashSet<Integer> numbers = new HashSet<>();

		while (numbers.size() < BaseballNumber.MAX_SIZE) {
			numbers.add(generateRandomSingleNumber());
		}

		return numbers;
	}

	private int generateRandomSingleNumber() {
		Random random = new Random();
		return random.nextInt(BaseballNumber.MAX_NUMBER) + 1;
	}

}
