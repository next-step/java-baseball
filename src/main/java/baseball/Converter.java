package baseball;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
public class Converter {
	List<Integer> toNumbers(String input) {
		if (input.length() != 3) {
			throw new WrongNumberInputException("길이가 3이 아닙니다.");
		}

		List<Integer> intList = toIntList(input);
		if (hasNotBetweenOneAneNineValue(intList) || hasEqualValue(intList)) {
			throw new WrongNumberInputException("1과 9 사이가 아니거나 같은 값이 존재합니다.");
		}

		return intList;
	}

	private List<Integer> toIntList(String input) {
		int first = input.charAt(0) - '0';
		int second = input.charAt(1) - '0';
		int third = input.charAt(2) - '0';

		return Arrays.asList(first, second, third);
	}

	private boolean hasNotBetweenOneAneNineValue(List<Integer> intList) {
		return !(intList.get(0) >= 1 && intList.get(0) <= 9)
			|| !(intList.get(1) >= 1 && intList.get(1) <= 9)
			|| !(intList.get(2) >= 1 && intList.get(2) <= 9);
	}

	private boolean hasEqualValue(List<Integer> intList) {
		return intList.get(0).equals(intList.get(1))
			|| intList.get(1).equals(intList.get(2))
			|| intList.get(2).equals(intList.get(0));
	}
}
