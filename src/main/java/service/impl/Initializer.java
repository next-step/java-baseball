package service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import service.IInitializer;

public class Initializer implements IInitializer {

	/**
	 * 컴퓨터의 초기 숫자값 세팅
	 */
	@Override
	public Map<Integer, Integer> initComputerNumbers() {
		Random random = new Random();

		// key: 숫자, value: 순서
		Map<Integer, Integer> computerNumbers = new HashMap<>();

		while (computerNumbers.size() < 3) {

			// key 값(숫자)이 중복되지 않은 경우에만 value 값(순서) 저장
			computerNumbers.putIfAbsent(random.nextInt(9) + 1, computerNumbers.size());
		}

		return computerNumbers;
	}
}
