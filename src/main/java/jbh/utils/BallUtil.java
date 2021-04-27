package jbh.utils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class BallUtil {

	public static String makeBall(int size) {
		return makeRandomNumberText(size);
	}

	public static boolean containCharInText(char character, String text) {
		Set<Character> charSet = new HashSet<>();
		for (char c : text.toCharArray()) {
			charSet.add(c);
		}
		return charSet.contains(character);
	}

	private static String makeRandomNumberText(int size) {
		StringBuilder stringBuilder = new StringBuilder();
		Set<Integer> randomSet = getRandomIntSet(size);
		randomSet.forEach(i -> stringBuilder.append(i));
		return stringBuilder.toString();
	}

	private static Set<Integer> getRandomIntSet(int size) {
		Random random = new Random();
		Set<Integer> tempSet = new LinkedHashSet<>();
		while (tempSet.size() < size) {
			tempSet.add(random.nextInt(8) + 1);
		}
		return tempSet;
	}
}
