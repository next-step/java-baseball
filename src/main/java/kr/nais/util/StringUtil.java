package kr.nais.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static List<Character> convertStringToListCharacter(String in) {
		List<Character> characterList = new ArrayList<>();
		for (char character : in.toCharArray()) {
			characterList.add(character);
		}
		return characterList;
	}
}
