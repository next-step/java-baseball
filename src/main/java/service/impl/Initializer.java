package service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import exception.InvalidValueException;
import service.IInitializer;

public class Initializer implements IInitializer {

	/**
	 * 컴퓨터의 초기 숫자 세팅
	 */
	@Override
	public Map<Integer, Integer> initComputerNumber() {

		// key: 숫자, value: 순서
		Map<Integer, Integer> computerNumber = new HashMap<>();
		while (computerNumber.size() < 3) {

			// key 값(숫자)이 중복되지 않은 경우에만 value 값(순서) 저장
			computerNumber.putIfAbsent(new Random().nextInt(9) + 1, computerNumber.size());
		}

		return computerNumber;
	}

	/**
	 * 플레이어가 제시한 숫자 세팅
	 */
	@Override
	public int[] initPlayerNumber(final int input) {
		final String inputStr = convertToString(input);

		int[] number = new int[3];
		for (int i = 0; i < 3; i++) {
			number[i] = convertToInt(inputStr.charAt(i));
		}

		return number;
	}

	/**
	 * 숫자를 문자열로 변경
	 */
	private String convertToString(final int input) {

		// 음수이거나 3자리가 아닌 경우 예외처리
		if (input < 100 || input > 999)
			throw new InvalidValueException();

		return String.valueOf(input);
	}

	/**
	 * 문자를 숫자로 변경
	 */
	private int convertToInt(final char digit) {

		// 1 ~ 9 가 아니면 예외처리
		if (digit == '0')
			throw new InvalidValueException();

		return digit - '0';
	}
}
