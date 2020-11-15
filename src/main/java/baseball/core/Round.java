package baseball.core;

import java.util.Map;
import java.util.HashMap;

public class Round {
	public static final int MAX_DIGITS = 3;
	private Map<Integer, Integer> numberMap;

	public Round(int value) {
		if (numberLength(value) != MAX_DIGITS) {
			throw new IllegalArgumentException(String.format("%d에 자릿수에 해당하는 숫자를 넘겨주시기 바랍니다.", MAX_DIGITS));
		}

		numberMap = new HashMap<>();

		for (int i = 0; i < MAX_DIGITS; i++) {
			numberMap.put(getPlaceValue(value, i), i);
		}
	}

	protected boolean isExsit(int number) {
		return numberMap.containsKey(number);
	}

	protected boolean isPlaceExsit(int number, int index) {
		if (isExsit(number)) {
			return numberMap.get(number) == index;
		}

		return false;
	}

	protected int numberLength(int number) {
		return (int)(Math.log10(number) + 1);
	}

	protected int getPlaceValue(int number, int index) {
		int length = numberLength(number);

		if (index >= length) {
			throw new IllegalArgumentException("index값이 number값에 자릿수 길이보다 같거나 깁니다.");
		}

		int t = (int)Math.pow(10, (length - 1) - index);
		return number % (t * 10) / t;
	}

}
