package com.baseball.rule;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.baseball.property.BaseBallSystem;

public class Pitcher {
	public int generateRandomDigit() {
		return new Random().nextInt(9) + 1;
	}

	public List<Integer> generateNumber() {
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		while (true) {
			int randomDigit = generateRandomDigit();
			randomNumberSet.add(randomDigit);
			if (randomNumberSet.size() > BaseBallSystem.NUMBER_LENGTH - 1) {
				break;
			}
		}
		return new ArrayList<>(randomNumberSet);
	}
}
