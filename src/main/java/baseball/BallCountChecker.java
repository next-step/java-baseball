package baseball;

import java.security.InvalidParameterException;

public class BallCountChecker {
	public static BallCount check(final String input, final String answer) {
		if (input.length() != 3 || !Validator.isNumber(input)) {
			throw new InvalidParameterException();
		}

		BallCount ballCount = new BallCount();

		for (int i = 0; i < BallCount.BALL_COUNT_SIZE; i++) {
			compare(i, input, answer, ballCount);
		}

		return ballCount;
	}

	private static void compare(final int index, final String input, final String answer, final BallCount ballCount) {
		if (isStrike(input.charAt(index), answer.charAt(index))) {
			ballCount.addStrike();
			return;
		}

		if (isBall(input.charAt(index), answer)) {
			ballCount.addBall();
		}
	}

	private static boolean isStrike(final char input, final char answer) {
		if (input == answer) {
			return true;
		}
		return false;
	}

	private static boolean isBall(final char input, final String answer) {
		if (answer.contains(Character.toString(input))) {
			return true;
		}
		return false;
	}
}
