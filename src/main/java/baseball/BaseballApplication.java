package baseball;

import baseball.utils.InputUtils;
import baseball.utils.RandomUtils;

public class BaseballApplication {
	public static void main(String[] args) {
		RandomUtils randomUtils = new RandomUtils();
		int[] result = randomUtils.createRandomNumber(1, 9);
		int[] userArray = InputUtils.getNumber(1, 9);
	}
}
