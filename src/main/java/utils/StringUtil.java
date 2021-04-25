package utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	public static List<Integer> stringToIntegerList(String input) {
		List<Integer> integerList = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			integerList.add(Character.getNumericValue(input.charAt(i)));
		}
		return integerList;
	}

	public static List<Integer> stringToIntegerListWithDelimiter(String input) {
		return stringToIntegerListWithDelimiter(input, ",");
	}

	public static List<Integer> stringToIntegerListWithDelimiter(String input, String delimiter) {
		String[] inputStrings = input.split(delimiter);
		List<Integer> integerList = new ArrayList<>();
		for (String string : inputStrings) {
			integerList.add(Integer.parseInt(string));
		}
		return integerList;
	}
}
