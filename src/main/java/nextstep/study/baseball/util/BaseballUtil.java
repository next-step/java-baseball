package nextstep.study.baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import nextstep.study.baseball.common.BaseConstants;

public class BaseballUtil {

	public static String removeDuplicateChar(String str) {
		Set<String> set = new LinkedHashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(String.valueOf(str.charAt(i)));
		}
		return String.join("", set);
	}

	public static List<String> convertIntListToStringList(List<Integer> intList) {
		List<String> stringList = new ArrayList<>();
		if (intList == null) {
			return stringList;
		}
		for (Integer value : intList) {
			stringList.add(String.valueOf(value));
		}
		return stringList;
	}

	public static void showMessage(String message) {
		System.out.print(message);
	}

	public static String getInputMessage(int makeCount) {
		if (makeCount > 0) {
			return BaseConstants.MESSAGE_INPUT_WRONG_NUMBER;
		}
		return BaseConstants.MESSAGE_INPUT_NUMBER;
	}

	public static boolean validationNumber(String inputNums) {
		String strRemovedDupChar = BaseballUtil.removeDuplicateChar(inputNums);
		return (isNumeric(inputNums) && isLength(strRemovedDupChar, BaseConstants.INPUT_NUMBER_LENGTH));
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer num = Integer.parseInt(strNum);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isLength(String strNum, int length) {
		if (strNum == null) {
			return false;
		}
		return strNum.length() == length;
	}

	public static List<Integer> strToList(String str) {
		if (str == null) {
			return new ArrayList<>();
		}
		Integer[] intArray = new Integer[str.length()];

		for (int i = 0; i < str.length(); i++) {
			intArray[i] = Character.digit(str.charAt(i), 10);
		}
		return Arrays.asList(intArray);
	}

}
