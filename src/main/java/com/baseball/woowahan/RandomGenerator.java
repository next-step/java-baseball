package com.baseball.woowahan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 랜덤 숫자 생성 모듈
 */
public class RandomGenerator {
	private final int MAX_NUMBER = 9;
	private final int MIN_NUMBER = 1;
	private List<Integer> allNumbers;

	public RandomGenerator() {
		this.allNumbers = new ArrayList<>();
	}

	public String makeRandomNumbers() {
		initAllNumbers();
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		while (stringBuilder.length() < GameManager.GAME_LENGTH) {
			int number = random.nextInt(allNumbers.size());
			stringBuilder.append(allNumbers.get(number));
			allNumbers.remove(number);
		}
		return stringBuilder.toString();
	}

	private void initAllNumbers() {
		for (int i = MIN_NUMBER; i < MAX_NUMBER; i++) {
			allNumbers.add(i);
		}
	}
}
