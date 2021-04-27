package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtil {

	public static List<Character> convertStrToList(String str) {
		char[] chars = str.toCharArray();
		List<Character> charList = new ArrayList<>();
		for (char aChar : chars) {
			charList.add(aChar);
		}
		return charList;
	}

	public static boolean hasOnlyNumber(List<Character> list) {
		List<Character> temp = new ArrayList<>(list);
		return !temp.removeIf(character -> !Character.isDigit(character));
	}

	public static boolean hasUniqueNumber(List<Character> list) {
		Set<Character> temp = new HashSet<>(list);
		return temp.size() == list.size();
	}
}
