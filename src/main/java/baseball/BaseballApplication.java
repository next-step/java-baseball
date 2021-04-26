package baseball;

import baseball.utils.RandomUtils;

public class BaseballApplication {
	public static void main(String[] args) {
		RandomUtils randomUtils = new RandomUtils();
		int[] result = randomUtils.createRandomNumber(1, 9);
	}
}
