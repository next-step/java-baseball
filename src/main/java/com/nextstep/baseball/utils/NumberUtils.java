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

	public static boolean checkStrike(String target, String input) {
		if (target.equals(input)) {
			System.out.println("3 스트라이크");
			return true;
		} else {
			String[] targetArr = target.split("");
			String[] inputArr = input.split("");
			String result = getJudge(targetArr, inputArr);
			System.out.println(result);
		}

		return false;
	}

	private static String getJudge(String[] targetArr, String[] inputArr) {
		int ballCount = 0;
		int strikeCount = 0;
		for (int i = 0; i < targetArr.length; i++) {
			if (targetArr[i].equals(inputArr[i])) {
				strikeCount++;
			} else {
				ballCount++;
			}
		}
		return print(ballCount, strikeCount);
	}

	private static String print(int ballCount, int strikeCount) {
		StringBuilder sb = new StringBuilder();
		if (strikeCount > 0) {
			sb.append(strikeCount).append("스트라이크");
		}
		if (strikeCount > 0 && ballCount > 0) {
			sb.append(" ");
		}
		if (ballCount > 0) {
			sb.append(ballCount).append("볼");
		}
		return sb.toString();
	}

}
