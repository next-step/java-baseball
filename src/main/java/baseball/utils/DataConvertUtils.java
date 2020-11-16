package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public final class DataConvertUtils {
	public static List<Integer> convertToIntegerArrays(String numbers) {
		String[] strNumbers = numbers.split("");
		List<Integer> intNumbers = new ArrayList<>();
		for (String strNumber : strNumbers) {
			intNumbers.add(Integer.valueOf(strNumber));
		}
		return intNumbers;
	}
}
