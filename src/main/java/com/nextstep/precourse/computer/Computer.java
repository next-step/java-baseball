package com.nextstep.precourse.computer;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
	private static final int ANSWER_LENGTH = 3;

	private String answer;

	public String generateNewAnswer() {
		Random random = null;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			random = new Random();
		}

		String newAnswer = "";
		List<Integer> selectedNumber = new ArrayList<>();
		while (newAnswer.length() != ANSWER_LENGTH) {
			newAnswer += generateRandomOneNumber(random, selectedNumber);
		}
		this.answer = newAnswer;
		return newAnswer;
	}

	private String generateRandomOneNumber(Random random, List<Integer> selectedNumber) {
		int randomNumber = random.nextInt(9) + 1;
		if (!selectedNumber.contains(randomNumber)) {
			selectedNumber.add(randomNumber);
			return Integer.toString(randomNumber);
		}
		return "";
	}

	public void ready() {
		generateNewAnswer();
	}
}
