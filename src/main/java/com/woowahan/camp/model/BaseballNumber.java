package com.woowahan.camp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.woowahan.camp.util.RandomUtil;

public class BaseballNumber {

	private List<String> numbers;

	private BaseballNumber(List<String> numbers) {
		this.numbers = numbers;
	}

	public static BaseballNumber of(String numStr) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(Character.toString(numStr.charAt(i)));
		}
		return new BaseballNumber(list);
	}

	public static BaseballNumber getRandomBaseballNumber() {
		return of(randomGenerator());
	}

	public GameResult checkStrikeAndBall(BaseballNumber other) {
		return GameResult.of(getStrikeCnt(other), getBallCnt(other), getInputValue(), other.getInputValue());
	}

	public static String randomGenerator() {
		List<String> numberList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int random = RandomUtil.randomNum(numberList.size());
			result.append(numberList.get(random));
			numberList.remove(random);
		}
		return result.toString();
	}

	public int getStrikeCnt(BaseballNumber other) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			strike += this.numbers.get(i).equals(other.numbers.get(i)) ? 1 : 0;
		}
		return strike;
	}

	public int getBallCnt(BaseballNumber other) {
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			ball += !this.numbers.get(i).equals(other.numbers.get(i))
				&& this.numbers.contains(other.numbers.get(i)) ? 1 : 0;
		}
		return ball;
	}

	public String getInputValue() {
		return String.join("", this.numbers);
	}

}


