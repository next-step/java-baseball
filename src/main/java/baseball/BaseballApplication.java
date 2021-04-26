package baseball;

import baseball.utils.HintUtils;
import baseball.utils.InputUtils;
import baseball.utils.RandomUtils;

public class BaseballApplication {
	public static void main(String[] args) {
		boolean success = true;
		int[] computerNumber = RandomUtils.createRandomNumber(1, 9);
		int[] userNumber = InputUtils.getNumber(1, 9);

		success = HintUtils.isThreeStrike(userNumber, computerNumber);
	}
}
