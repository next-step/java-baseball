package util;

import java.util.Set;
import java.util.HashSet;

public class NumberBaseballGameNumbersGenerator {
	static public int[] generateUniqueNumbers(int size) {
		Set<Integer> chosenNumbers = new HashSet<>();
		int[] numbers = new int[size];

		do {
			int newNumber = generateNewUniqueNumber(chosenNumbers);

			numbers[chosenNumbers.size()] = newNumber;
			chosenNumbers.add(newNumber);
		} while (chosenNumbers.size() < size);

		return numbers;
	}

	static private int generateNewUniqueNumber(Set<Integer> exclusionSet) {
		int newRandomNumber = 0;

		do {
			newRandomNumber = (int) (Math.random() * 9) + 1;
		} while (exclusionSet.contains(newRandomNumber));

		return newRandomNumber;
	}
}
