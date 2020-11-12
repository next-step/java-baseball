package com.woowahan.camp.model;

import java.util.ArrayList;
import java.util.List;

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
		throw new RuntimeException("컴퓨터의 랜덤 숫자 객체를 반환한다.");
	}

	public GameResult checkStrikeAndBall(BaseballNumber other) {
		throw new RuntimeException("사용자 입력값과 비교하여 스트라이크와 볼등의 결과 정보가 담긴 결과객체를 반환한다.");
	}

}


