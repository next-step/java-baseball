package com.pointware.game.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

	private final List<String> numberList;

	public RandomNumber() {
		this.numberList = getNumberList();
	}

	private List<String> getNumberList() {
		List<String> numbers = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			numbers.add(String.valueOf(i));
		}
		return numbers;
	}

	public int generateNumber(int digit) {
		doShuffledNumberList();
		String number = joinNumberList(pickNumbers(digit));
		return Integer.parseInt(number);
	}

	private void doShuffledNumberList() {
		Collections.shuffle(numberList);
	}

	private List<String> pickNumbers(int digit) {
		return this.numberList.subList(0, digit);
	}

	private String joinNumberList(List<String> shuffledNumberList) {
		StringBuilder gameNumberBuilder = new StringBuilder();
		for (String number : shuffledNumberList) {
			gameNumberBuilder.append(number);
		}
		return gameNumberBuilder.toString();
	}

}
