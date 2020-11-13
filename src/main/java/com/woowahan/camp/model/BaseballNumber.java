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

	public static BaseballNumber getBaseballNumber(String numStr) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(Character.toString(numStr.charAt(i)));
		}
		return new BaseballNumber(list);
	}

	public static BaseballNumber getRandomBaseballNumber() {
		return getBaseballNumber(randomGenerator());
	}

	public GameResult checkStrikeAndBall(BaseballNumber other) {
		throw new RuntimeException("사용자 입력값과 비교하여 스트라이크와 볼등의 결과 정보가 담긴 결과객체를 반환한다.");
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

}


