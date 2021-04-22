package nextstep.study.baseball.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
}
