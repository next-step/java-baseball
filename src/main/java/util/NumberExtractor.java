package util;

import java.util.Random;

public class NumberExtractor {
	public static int random(int max) {
		return new Random().nextInt(max) + 1;
	}
}
