package com.nextstep.precourse.computer;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Computer {
	private String answer = "000";

	public String generateNewAnswer() {
		int randomNumber = 0;
		try {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			randomNumber = secureRandom.nextInt(1000);
		} catch (NoSuchAlgorithmException e) {
			Random random = new Random();
			randomNumber = random.nextInt(1000);
		}
		return String.format("%03d", randomNumber);
	}

	public void startNewGame() {
		this.answer = generateNewAnswer();
	}
}
