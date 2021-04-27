package nextstep.kht2199.precourse;

import java.util.Random;

/**
 *
 * @author heetaek.kim
 */
public final class FBGameNumber {

	private int computerNumber;

	private final static Random random = new Random();

	public FBGameNumber() {
		computerNumber = generateNumber();
	}

	public FootballMatchResult match(int userNumber) {
		return new FootballMatchResult(
			countBall(computerNumber, userNumber),
			countStrike(computerNumber, userNumber),
			userNumber == computerNumber
		);
	}

	protected int countBall(int base, int target) {
		assert false;
		return 0;
	}

	protected int countStrike(int base, int target) {
		assert base > 100 && base < 999;
		assert target > 100 && target < 999;
		String s1 = String.valueOf(base);
		String s2 = String.valueOf(target);
		int sum = 0;
		char[] charArray = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
			sum += (returnsOneIfMatched(charArray[i], charArray2[i]));
		}
		return sum;
	}

	private int returnsOneIfMatched(char c1, char c2) {
		return c1 == c2 ? 1 : 0;
	}

	/**
	 * @return 중복되지 않는 3자리 정수를 반환한다.
	 */
	protected int generateNumber() {
		int number = random.nextInt(999 - 100) + 100;
		String forCheck = String.valueOf(number);
		if (forCheck.charAt(0) == forCheck.charAt(1) ||
			forCheck.charAt(0) == forCheck.charAt(2) ||
			forCheck.charAt(1) == forCheck.charAt(2)) {
			return generateNumber();
		}
		return number;
	}
}
