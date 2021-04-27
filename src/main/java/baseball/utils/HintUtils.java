package baseball.utils;

import java.util.HashSet;
import java.util.Set;

import baseball.domain.HintType;

public class HintUtils {
	public HintUtils() {
	}

	public static boolean isThreeStrike(int[] userNumber, int[] computerNumber) {
		int strikeCount = getStrikeCount(userNumber, computerNumber);
		int ballCount = getBallCount(userNumber, computerNumber, strikeCount);

		printStrike(strikeCount);
		printBall(ballCount);
		printNothing(strikeCount, ballCount);

		return (strikeCount == 3);
	}

	private static int getBallCount(int[] userNumber, int[] computerNumber, int strikeCount) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < userNumber.length; i++) {
			set.add(userNumber[i]);
			set.add(computerNumber[i]);
		}

		return (userNumber.length * 2) - set.size() - strikeCount;
	}

	private static int getStrikeCount(int[] userNumber, int[] computerNumber) {
		int count = 0;
		for (int i = 0; i < userNumber.length; i++) {
			count += isStrike(userNumber[i], computerNumber[i]);
		}

		return count;
	}

	private static int isStrike(int userDigit, int computerDigit) {
		if (userDigit == computerDigit) {
			return 1;
		}

		return 0;
	}

	private static void printNothing(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.print(HintType.NOTHING.getMessage());
		}
		System.out.println();
	}

	private static void printBall(int ballCount) {
		if (ballCount > 0) {
			System.out.print(ballCount + HintType.BALL.getMessage());
		}
	}

	private static void printStrike(int strikeCount) {
		if (strikeCount > 0) {
			System.out.print(strikeCount + " " + HintType.STRIKE.getMessage() + " ");
		}
	}
}
