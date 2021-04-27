package nextstep.kht2199.precourse;

/**
 *
 * @author heetaek.kim
 */
public final class FBGameNumber {

	private final int computerNumber;

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

	private int countBall(int base, int target) {
		assert false;
		return 0;
	}

	private int countStrike(int base, int target) {
		assert false;
		return 0;
	}

	/**
	 * @return 중복되지 않는 3자리 정수를 반환한다.
	 */
	private int generateNumber() {
		assert false;
		return 0;
	}

}
