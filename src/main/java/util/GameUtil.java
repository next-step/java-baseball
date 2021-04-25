package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import constant.NumberValidation;

public class GameUtil {
	public static final int LIMIT_DIGIT = 3;
	public static final int MIN_DIGIT = 1;
	public static final int MAX_DIGIT = 9;

	public static String getRandomNumber() {
		String number = null;
		do {
			number = makeRandomNumber();
		} while (!validateNumberFormat(number));
		return number;
	}

	private static boolean validateNumberFormat(String number) {
		boolean isRightFlag = true;
		for (NumberValidation validation : NumberValidation.values()) {
			isRightFlag = isRightFlag && validation.getValidate().test(number);
		}
		return isRightFlag;
	}

	private static String makeRandomNumber() {
		List<Integer> digits = getShuffleList(getDifferentSet());
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer digit : digits) {
			stringBuilder.append(digit);
		}
		return stringBuilder.toString();
	}

	private static Set<Integer> getDifferentSet() {
		Random random = new Random();
		Set<Integer> digits = new HashSet<>();
		while (digits.size() < LIMIT_DIGIT) {
			digits.add(random.nextInt(MAX_DIGIT - MIN_DIGIT + 1) + MIN_DIGIT);
		}
		return digits;
	}

	private static List<Integer> getShuffleList(Set<Integer> digits) {
		List<Integer> digitList = new ArrayList<>(digits);
		Collections.shuffle(digitList);
		return digitList;
	}
}
