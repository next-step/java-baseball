package woo.baseball.utils;

import java.util.Random;

public class BaseBallUtils {

	private final static int MAX_NUMBER = 999;
	private final static int MIN_NUMBER = 100;

	public static int ballNumberGenerator() {
		return new Random().nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
	}

}
