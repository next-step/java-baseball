package com.precourse.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
	private final Random random = new Random();

	/**
	 * 서로 다른 3개의 수를 생성한다.
	 * @return 서로 다른 3개의 수
	 */
	public List<Integer> generate() {
		Set<Integer> numSet = new HashSet<>();
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < Constants.LENGTH_OF_NUMBER; i++) {
			int number = getUniqueNumber(numSet);
			numList.add(number);
		}
		return numList;
	}

	/**
	 * numSet 에 포함되어 있지 않은 1-9사이의 수를 구한다.
	 * @param numSet : 기준 Set
	 * @return 중복되지 않는 숫자
	 */
	public int getUniqueNumber(Set<Integer> numSet) {
		int number;
		do {
			number = random.nextInt(9) + 1;
		} while (numSet.contains(number));
		numSet.add(number);
		return number;
	}

}
