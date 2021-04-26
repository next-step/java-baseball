package jbh.utils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class BallUtil {

	public static String makeBall(int size) {
		return makeRandomNumberText(size);
	}

	private static String makeRandomNumberText(int size) {
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		Set<Integer> tempSet = new LinkedHashSet<>();
		while (tempSet.size() < 3) {
			tempSet.add(random.nextInt(8) + 1);
		}
		tempSet.forEach(i -> stringBuilder.append(i));
		return stringBuilder.toString();
	}

	public static boolean containCharInText(char character, String text) {
		Set<Character> charSet = new HashSet<>();
		for (char c : text.toCharArray()) {
			charSet.add(c);
		}
		return charSet.contains(character);
	}
}
