package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtils {

	public static List<Integer> pickRandomInSerialNumbers(int maxAmount, int pickNumber) {
		List<Integer> serialNumbers = new ArrayList<>(maxAmount);
		for (int i = 1; i <= maxAmount; i++) {
			serialNumbers.add(i);
		}
		Collections.shuffle(serialNumbers);
		return serialNumbers.subList(0, pickNumber);
	}
}
