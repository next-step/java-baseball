package com.baseball.rule;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Pitcher {
	static int LENGTH = 3;

	public int generateRandomDigit() {
		return new Random().nextInt(9) + 1;
	}

	public List<Integer> generateNumber() {
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		while (true) {
			int randomDigit = generateRandomDigit();
			randomNumberSet.add(randomDigit);
			if(randomNumberSet.size()>LENGTH-1) {
				break;
			}
		}
		return new ArrayList<>(randomNumberSet);
	}
}
