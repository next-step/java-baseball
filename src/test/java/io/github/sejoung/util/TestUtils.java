package io.github.sejoung.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TestUtils {

	public static List<Set<Integer>> makeNumberList(String computerNumber) {
		Set<Integer> baseballNumber = new HashSet<>();
		char[] chars = computerNumber.toCharArray();
		for (char number : chars) {
			baseballNumber.add(Character.getNumericValue(number));
		}
		return conversionSet(baseballNumber);
	}

	private static List<Set<Integer>> conversionSet(Set<Integer> baseballNumber) {
		List<Set<Integer>> numberList = new ArrayList<>();
		baseballNumber.forEach(integer -> {
			Set<Integer> tempSet = new HashSet<>();
			tempSet.add(integer);
			numberList.add(tempSet);
		});
		return numberList;
	}

}
