package baseball;

import java.util.ArrayList;
import java.util.List;

public class Utils {

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
