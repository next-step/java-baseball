package com.nextstep.baseball.utils;

import java.util.Random;

public final class NumberUtils {

	private static final String[] STRIKE_ZONE = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

	private static final Random random = new Random();

	public static String[] getRandomThreeDigitNumber() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (count < 3) {
			int target = random.nextInt(9);
			String temp = STRIKE_ZONE[target];
			if (!sb.toString().contains(temp)) {
				sb.append(temp);
				count++;
			}
		}

		return sb.toString().split("");
	}
}
