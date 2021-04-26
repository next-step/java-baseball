package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	/**
	 * convert string to integer list
	 * @param str : int value as string
	 * @return List<Integer>
	 */
	public static List<Integer> convertStringToIntegerList(String str) {
		List<Integer> ret = new ArrayList<>();
		for (String s : str.split("")) {
			ret.add(Integer.parseInt(s));
		}
		return ret;
	}
}
