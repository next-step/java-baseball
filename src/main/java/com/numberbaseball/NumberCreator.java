package com.numberbaseball;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import jdk.internal.joptsimple.internal.Strings;

public class NumberCreator {
	public static final int MAX_NUMBER_LENGTH = 3;

	public int createEachNumberIsUniqueThreeDigitNumber() {
		Set<Integer> numberCandidates = createNumberCandidates();
		return toNumber(numberCandidates);
	}

	private Set<Integer> createNumberCandidates() {
		Set<Integer> randomNumbers = new LinkedHashSet<>();

		while (randomNumbers.size() < MAX_NUMBER_LENGTH) {
			randomNumbers.add((int)(Math.random() * 9) + 1);
		}
		return randomNumbers;
	}

	private Integer toNumber(Set<Integer> randomNumbers) {
		String answer = Strings.EMPTY;
		for (Integer number : randomNumbers) {
			answer += number;
		}

		return Integer.valueOf(answer);
	}
}
