package baseball.game.gameball;

/**
 * 게임 볼을 구성하는 숫자 객체
 */
class GameNumber {

	private final Integer num;

	private GameNumber(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}

	/**
	 * 구현 정책
	 */
	public static class Policy {
		public static final int MIN_RANGE = 1;    // 최소 1
		public static final int MAX_RANGE = 9;    // 최대 9

		public static boolean isSatisfied(Integer num) {
			return num < MIN_RANGE || num > MAX_RANGE;
		}
	}

	public static GameNumber create(Integer num) {

		if (Policy.isSatisfied(num)) {
			throw new IllegalArgumentException();
		}
		return new GameNumber(num);
	}

	public static GameNumber create(char charNum) {

		Integer num = Character.getNumericValue(charNum);
		if (Policy.isSatisfied(num)) {
			throw new IllegalArgumentException();
		}
		return new GameNumber(num);
	}

}
