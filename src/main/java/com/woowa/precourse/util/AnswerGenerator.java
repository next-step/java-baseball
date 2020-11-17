package com.woowa.precourse.util;

import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator {
	int[] uniqueNumber = new int[3];
	Set<Integer> numberSet = new HashSet<>();

	/* 유니크한 수 생성(정답) */
	public Answer create() {
		numberSet.add(0);

		for (int i = 0; i < uniqueNumber.length; i++) {
			int number = 0;
			number = setNumber(numberSet, number);

			numberSet.add(number);
			uniqueNumber[i] = number;
		}

		return new Answer(uniqueNumber);
	}

	/* 중복 수 포함 여부 확인 */
	private int setNumber(Set<Integer> numberSet, int number) {
		while (numberSet.contains(number)) {
			number = (int) (Math.random() * 10);
		}

		return number;
	}
}
