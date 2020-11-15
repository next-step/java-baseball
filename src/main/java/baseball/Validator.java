package baseball;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Validator {
	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean isLength3(String input) {
		return Objects.nonNull(input) && input.length() == 3 ? true : false;
	}

	public static boolean isNumber1Or2(String input) {
		return "1".equals(input) || "2".equals(input) ? true : false;
	}

	public static boolean isDuplicate(String input) {
		Set<Character> numberSet = new HashSet<>();
		for(char c : input.toCharArray()){
			numberSet.add(c);
		}
		return numberSet.size() == 3 ? true : false;
	}
}
