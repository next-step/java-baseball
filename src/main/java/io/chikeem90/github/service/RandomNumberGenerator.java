package io.chikeem90.github.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
	@Override
	public List<Character> generateNumber() {
		List<Character> generatedNumber = new ArrayList<>();
		Random random = new Random();
		while (generatedNumber.size() < 3) {
			// 1 ~ 9까지
			this.addNumber(generatedNumber, (char)(random.nextInt(9) + 49));
		}
		return generatedNumber;
	}

	private void addNumber(List<Character> generatedNumber, char number) {
		if (!generatedNumber.contains(number)) {
			generatedNumber.add(number);
		}
	}
}
