package exam.baseball;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Utility {
	private static final Integer[] DEFAULT_RANGE = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static final int SIZE_OF_ANSWER = 3;
			
	private static List<Integer> getDefaultRangeList() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < DEFAULT_RANGE.length; i++) {
			list.add(DEFAULT_RANGE[i]);
		}
		return list;
	}
	
	public static String getRandom3Numbers() {
		SecureRandom random = new SecureRandom();
		List<Integer> list = getDefaultRangeList();
		String randomNumbers = "";
		for (int i = 0; i < SIZE_OF_ANSWER; i++) {
			int randomIndex = random.nextInt(list.size());
			Integer selected = list.remove(randomIndex);
			randomNumbers += selected.toString();
		}
		return randomNumbers;
	}
}
