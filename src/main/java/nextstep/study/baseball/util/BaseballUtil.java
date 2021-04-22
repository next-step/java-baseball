package nextstep.study.baseball.util;

import java.util.HashSet;
import java.util.Set;

public class BaseballUtil {

	public static String removeDuplicateChar(String str) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(String.valueOf(str.charAt(i)));
		}
		return String.join("", set);
	}

}
