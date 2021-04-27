package util;

import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGameTypeConverter {
	static public int[] convertStringToIntArray(String target) {
		int[] result = new int[target.length()];

		for (int i = 0; i < target.length(); i++) {
			result[i] = target.charAt(i) - '0';
		}

		return result;
	}

	static public Set<Integer> convertIntArrayToSet(int[] target) {
		Set<Integer> result = new HashSet<>();

		for (int num : target) {
			result.add(num);
		}

		return result;
	}
}
