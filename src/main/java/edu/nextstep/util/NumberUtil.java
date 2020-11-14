package edu.nextstep.util;

import java.util.Random;

public class NumberUtil {
	public static String generateRandomSingleNumber() {
		Random random = new Random();
		random.setSeed(System.nanoTime());
		int number = random.nextInt(9) + 1;
		return String.valueOf(number);
	}

	public static String generateNonDuplicatedSingleNumber(String existingNumber) {
		String newNumber = "";
		if (existingNumber.length() > 8) {
			throw new RuntimeException("Only numbers of 8 digits or less are possible");
		}
		while (existingNumber.contains(newNumber = generateRandomSingleNumber())) {}
		return newNumber;
	}

	public static String generateNonDuplicatedNumber(int numberSize) {
		String selectedNumber = "";
		for (int i = 0; i < numberSize; i++) {
			selectedNumber += generateNonDuplicatedSingleNumber(selectedNumber);
		}
		return selectedNumber;
	}
}
